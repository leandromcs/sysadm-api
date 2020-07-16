package com.example.sysadm.service;

import com.example.sysadm.model.Operador;
import com.example.sysadm.repository.LoginRepository;
import com.example.sysadm.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Operador cadastrarOperador(Operador operador) {
        operador.setDataCadastro(LocalDate.now());
        return repository.save(operador);
    }
}
