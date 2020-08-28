package com.example.sysadm.repository;

import com.example.sysadm.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    Pessoa findById(String id);

    Pessoa findPessoaByDocumento(String documento);


}
