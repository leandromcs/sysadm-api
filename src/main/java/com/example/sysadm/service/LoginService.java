package com.example.sysadm.service;

import com.example.sysadm.model.Operador;
import com.example.sysadm.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private LoginRepository repository;

    @Autowired
    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    public String login(Operador operador) {
        Operador login = repository.findByLoginAndSenha(operador.getLogin(), operador.getSenha());
        if (login != null) {

        }
        return "token";
    }
}
