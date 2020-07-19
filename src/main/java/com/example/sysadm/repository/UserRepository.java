package com.example.sysadm.repository;

import com.example.sysadm.model.Operador;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Operador, Long> {

    Operador findByLogin(String login);
}
