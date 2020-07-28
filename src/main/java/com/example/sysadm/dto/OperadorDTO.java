package com.example.sysadm.dto;

import com.example.sysadm.enums.PerfilEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class OperadorDTO {

    @NotNull
    @Size(max = 100)
    @Pattern(regexp = "^[A-Za-z ]*$")
    private String nome;

    @NotNull
    @Size(max = 15)
    @Pattern(regexp = "^[A-Za-z-_]*$")
    private String login;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;

    @NotNull
    private LocalDate dataCadastro;

    public OperadorDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public PerfilEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEnum perfil) {
        this.perfil = perfil;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
