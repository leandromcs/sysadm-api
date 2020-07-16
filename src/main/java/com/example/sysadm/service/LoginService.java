package com.example.sysadm.service;

import com.example.sysadm.model.Operador;
import com.example.sysadm.repository.LoginRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class LoginService {

    private LoginRepository repository;
    private final long expirationTime = 18000000;
    private String key = "String aleatoria";

    @Autowired
    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    public String login(Operador operador) {
        Operador login = repository.findByLoginAndSenha(operador.getLogin(), operador.getSenha());
        String jws;
        if (login != null) {
            jws = Jwts.builder()
                    .setIssuedAt(new Date())
                    .setSubject(operador.getLogin())
                    .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                    .signWith(SignatureAlgorithm.HS256, key)
                    .compact();
            return jws;
        }
        return null;
    }
}
