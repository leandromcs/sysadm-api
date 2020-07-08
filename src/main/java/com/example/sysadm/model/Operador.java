package com.example.sysadm.model;

import com.example.sysadm.enums.PerfilEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Pattern(regexp = "^[A-Za-z ]*$")
    private String nome;

    @NotNull
    @Size(max = 15)
    @Pattern(regexp = "^[A-Za-z-_]*$")
    private String login;

    @NotNull
    @Size(min = 6, max = 15)
    @Pattern(regexp = "/^\\S/")
    private String senha;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;

    @NotNull
    private LocalDate dataCadastro;

    public Operador() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
