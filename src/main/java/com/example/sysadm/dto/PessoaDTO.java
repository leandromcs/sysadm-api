package com.example.sysadm.dto;

import com.example.sysadm.enums.TipoPessoaEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PessoaDTO {

    @NotNull
    @Size(max = 100)
    @Pattern(regexp = "^([^0-9]*)$")
    private String nome;

    @NotNull
    private String documento;

    @NotNull
    private LocalDate dataNascimento;

    private LocalDate dataCadastro;

    private String loginCadastro;

    @Enumerated(EnumType.STRING)
    private TipoPessoaEnum tipoPessoa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public TipoPessoaEnum getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
