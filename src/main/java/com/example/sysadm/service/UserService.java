package com.example.sysadm.service;

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
        Operador login = repository.findByLogin(operador.getLogin());
        if (login != null) {
            return null;
        }
        operador.setDataCadastro(LocalDate.now());
        return repository.save(operador);
    }

    public List<Operador> listarOperadores() {
        Iterable<Operador> all = repository.findAll();
        List<Operador> operadores = new ArrayList<>();
        all.forEach(operadores::add);
        return operadores;
    }

    public Operador buscarOperadorPorLogin(String login) {
        return repository.findByLogin(login);
    }
}
