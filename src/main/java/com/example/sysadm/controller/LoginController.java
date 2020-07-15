package com.example.sysadm.controller;

import com.example.sysadm.model.Operador;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {



    @PostMapping("/login")
    public String login(@RequestBody Operador operador) {
        return "token";
    }
}
