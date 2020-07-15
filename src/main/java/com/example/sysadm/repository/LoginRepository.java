package com.example.sysadm.repository;

import com.example.sysadm.model.Operador;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Operador, Long> {

    Operador findByLoginAndSenha(String login, String senha);
}
