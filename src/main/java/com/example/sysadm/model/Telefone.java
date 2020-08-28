package com.example.sysadm.model;

import com.example.sysadm.enums.TipoTelefoneEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 3)
    private Integer ddd;

    @NotNull
    @Size(min = 8, max = 10)
    private Integer numero;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoTelefoneEnum tipoTelefone;

    private LocalDate dataCadastro;

    private String loginCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoTelefoneEnum getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefoneEnum tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getLoginCadastro() {
        return loginCadastro;
    }

    public void setLoginCadastro(String loginCadastro) {
        this.loginCadastro = loginCadastro;
    }
}
