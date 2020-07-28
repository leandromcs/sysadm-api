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

    @NotNull(message = "Nome não pode ser nulo")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "Nome inválido")
    private String nome;

    @NotNull(message = "Login não pode ser nulo")
    @Size(max = 15, message = "Login deve ter no máximo 15 caracteres")
    @Pattern(regexp = "^[A-Za-z-_]*$", message = "Login inválido")
    private String login;

    @NotNull(message = "Senha não pode ser nula")
    @Size(min = 6, max = 15, message = "Senha deve ter no mínimo 6 e no máximo 15 caracteres")
    private String senha;

    @NotNull(message = "Perfil não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;

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
