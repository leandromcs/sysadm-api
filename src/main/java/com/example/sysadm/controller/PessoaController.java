package com.example.sysadm.controller;

import com.example.sysadm.dto.PessoaDTO;
import com.example.sysadm.model.Pessoa;
import com.example.sysadm.model.Telefone;
import com.example.sysadm.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService service;

    @Autowired
    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarPessoa(@Validated @RequestBody Pessoa pessoa) {
        Pessoa pessoaCadastrada = service.cadastrarPessoa(pessoa);
        if (pessoaCadastrada != null) {
            return new ResponseEntity<>("Pessoa cadastrada com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Pessoa não cadastrada.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/cadastrarTelefones/{documento}")
    public ResponseEntity<String> cadastrarTelefones(@RequestBody List<Telefone> telefones, @PathVariable("documento") String documento) {
        Pessoa pessoaCadastrada = service.cadastrarTelefones(telefones, documento);
        if (pessoaCadastrada != null) {
            return new ResponseEntity<>("Pessoa cadastrada com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Pessoa não cadastrada.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaDTO>> listarPessoas() {
        List<PessoaDTO> dtos = service.listarPessoas();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/listar/{documento}")
    public ResponseEntity<Pessoa> listarPessoa(@PathVariable("documento") String documento) {
        Pessoa p = service.listaPessoa(documento);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editarPessoa(@RequestBody PessoaDTO pessoa) {
        Pessoa p = service.editarPessoa(pessoa);
        if (p != null) {
            return new ResponseEntity<>("Pessoa editada com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Pessoa não editada.", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/excluir/{documento}")
    public ResponseEntity<String> excluirPessoa(@PathVariable("documento") String documento) {
        service.excluirPessoa(documento);
        return new ResponseEntity<>("Pessoa excluida com sucesso!", HttpStatus.OK);
    }
}
