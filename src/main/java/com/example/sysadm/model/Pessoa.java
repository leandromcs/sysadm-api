package com.example.sysadm.model;

import com.example.sysadm.enums.TipoPessoaEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Pattern(regexp = "^([^0-9]*)$")
    private String nome;

    @NotNull
    private String documento;

    @NotNull
    private LocalDate dataNascimento;

    @Size(max = 100)
    @Pattern(regexp = "^([^0-9]*)$")
    private String nomeMae;

    @Size(max = 100)
    @Pattern(regexp = "^([^0-9]*)$")
    private String nomePai;

    private LocalDate dataCadastro;

    private String loginCadastro;

    @Enumerated(EnumType.STRING)
    private TipoPessoaEnum tipoPessoa;

    @OneToMany
    private List<Telefone> telefones;

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

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
