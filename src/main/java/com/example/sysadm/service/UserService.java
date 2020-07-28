package com.example.sysadm.service;

import com.example.sysadm.dto.OperadorDTO;
import com.example.sysadm.interceptor.AuthenticationData;
import com.example.sysadm.model.Operador;
import com.example.sysadm.repository.LoginRepository;
import com.example.sysadm.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Operador cadastrarOperador(Operador operador) {
        if (!operador.getPerfil().toString().equals("ADMINISTRADOR")
                && AuthenticationData.getLoggedUser().getPerfil().toString().equals("ADMINISTRADOR")) {
            Operador login = repository.findByLogin(operador.getLogin());
            if (login != null) {
                return null;
            }
            operador.setDataCadastro(LocalDate.now());
            return repository.save(operador);
        }
        return null;
    }

    public List<OperadorDTO> listarOperadores() {
        if (AuthenticationData.getLoggedUser().getPerfil().toString().equals("ADMINISTRADOR")) {
            Iterable<Operador> all = repository.findAll();
            List<OperadorDTO> operadores = new ArrayList<>();
            all.forEach(operador -> {
                OperadorDTO dto = new OperadorDTO();
                dto.setNome(operador.getNome());
                dto.setLogin(operador.getLogin());
                dto.setDataCadastro(operador.getDataCadastro());
                dto.setPerfil(operador.getPerfil());

                operadores.add(dto);
            });

            return operadores;
        }
        return new ArrayList<>();
    }

    public Operador buscarOperadorPorLogin(String login) {
        return repository.findByLogin(login);
    }
}
