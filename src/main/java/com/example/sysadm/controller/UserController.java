package com.example.sysadm.controller;

import com.example.sysadm.model.Operador;
import com.example.sysadm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarOperador(@RequestBody Operador operador) {
        Operador operadorCadastrado = service.cadastrarOperador(operador);
        if (operadorCadastrado != null) {
            return new ResponseEntity<>("Operador cadastrado com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Operador não cadastrado.", HttpStatus.BAD_REQUEST);
    }
}
