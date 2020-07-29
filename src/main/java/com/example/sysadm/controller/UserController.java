package com.example.sysadm.controller;

import com.example.sysadm.dto.OperadorDTO;
import com.example.sysadm.model.Operador;
import com.example.sysadm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operador")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarOperador(@Validated @RequestBody Operador operador) {
        Operador operadorCadastrado = service.cadastrarOperador(operador);
        if (operadorCadastrado != null) {
            return new ResponseEntity<>("Operador cadastrado com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Operador não cadastrado.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<OperadorDTO>> listarOperadores() {
        List<OperadorDTO> operadores = service.listarOperadores();
        return new ResponseEntity<>(operadores, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editarOperador(@RequestBody Operador operador) {
        Operador operadorCadastrado = service.editarOperador(operador);
        if (operadorCadastrado != null) {
            return new ResponseEntity<>("Operador editado com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Operador não editado.", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarOperador(@RequestParam String login) {
        service.excluirOperador(login);
        return new ResponseEntity<>("Operador deletado com sucesso!", HttpStatus.OK);
    }
}
