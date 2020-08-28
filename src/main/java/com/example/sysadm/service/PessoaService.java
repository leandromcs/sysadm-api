package com.example.sysadm.service;

import com.example.sysadm.dto.PessoaDTO;
import com.example.sysadm.enums.PerfilEnum;
import com.example.sysadm.enums.TipoPessoaEnum;
import com.example.sysadm.interceptor.AuthenticationData;
import com.example.sysadm.model.Operador;
import com.example.sysadm.model.Pessoa;
import com.example.sysadm.model.Telefone;
import com.example.sysadm.repository.PessoaRepository;
import com.example.sysadm.utils.DocumentoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository repository;

    @Autowired
    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        Operador loggedUser = AuthenticationData.getLoggedUser();
        if (loggedUser.getPerfil().equals(PerfilEnum.GERENTE)) {
            pessoa.setDataCadastro(LocalDate.now());
            pessoa.setLoginCadastro(loggedUser.getLogin());

            //Validação de Data de Nascimento
            if (!pessoa.getDataNascimento().isBefore(LocalDate.now())) {
                return null;
            }

            //Validação de Documento
            if (DocumentoUtil.isCPF(pessoa.getDocumento())) {
                pessoa.setTipoPessoa(TipoPessoaEnum.FISICA);
            } else if (DocumentoUtil.isCNPJ(pessoa.getDocumento())) {
                pessoa.setTipoPessoa(TipoPessoaEnum.JURIDICA);
            } else {
                return null;
            }

            return repository.save(pessoa);
        }
        return null;
    }

    public Pessoa cadastrarTelefones(List<Telefone> telefones, String documento) {
        Operador loggedUser = AuthenticationData.getLoggedUser();
        if (loggedUser.getPerfil().equals(PerfilEnum.GERENTE)) {
            Pessoa pessoa = repository.findPessoaByDocumento(documento);
            pessoa.setTelefones(telefones);
            return repository.save(pessoa);
        }
        return null;
    }

    public List<PessoaDTO> listarPessoas() {
        Operador loggedUser = AuthenticationData.getLoggedUser();
        if (loggedUser.getPerfil().equals(PerfilEnum.GERENTE) || loggedUser.getPerfil().equals(PerfilEnum.ANALISTA)) {
            List<PessoaDTO> dtos = new ArrayList<>();
            Iterable<Pessoa> all = repository.findAll();
            all.forEach(p -> {
                PessoaDTO dto = new PessoaDTO();
                dto.setDataCadastro(p.getDataCadastro());
                dto.setDataNascimento(p.getDataNascimento());
                dto.setDocumento(p.getDocumento());
                dto.setLoginCadastro(p.getLoginCadastro());
                dto.setNome(p.getNome());
                dto.setTipoPessoa(p.getTipoPessoa());
                dtos.add(dto);
            });
            return dtos;
        }
        return new ArrayList<>();
    }

    public Pessoa listaPessoa(String documento) {
        Operador loggedUser = AuthenticationData.getLoggedUser();
        if (loggedUser.getPerfil().equals(PerfilEnum.GERENTE) || loggedUser.getPerfil().equals(PerfilEnum.ANALISTA)) {
            return repository.findPessoaByDocumento(documento);
        }
        return new Pessoa();
    }

    public Pessoa editarPessoa(PessoaDTO dto) {
        Operador loggedUser = AuthenticationData.getLoggedUser();
        if (loggedUser.getPerfil().equals(PerfilEnum.GERENTE)) {
            Pessoa pessoa = repository.findPessoaByDocumento(dto.getDocumento());
            pessoa.setNome(dto.getNome());
            pessoa.setDataNascimento(dto.getDataNascimento());
            pessoa.setTipoPessoa(dto.getTipoPessoa());
            return repository.save(pessoa);
        }
        return null;
    }

    public void excluirPessoa(String documento) {
        Operador loggedUser = AuthenticationData.getLoggedUser();
        if (loggedUser.getPerfil().equals(PerfilEnum.GERENTE)) {
            Pessoa pessoaToDelete = repository.findPessoaByDocumento(documento);
            repository.delete(pessoaToDelete);
        }
    }
}
