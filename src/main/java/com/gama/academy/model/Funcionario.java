package com.gama.academy.model;

import com.gama.academy.enums.TipoConta;
import com.gama.academy.enums.UnidadeSalarial;
import com.gama.academy.mapper.EnderecoMapper;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank
    private String cpf;
    @NotBlank
    private String matricula;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotNull
    private LocalDate dataAdmissao;
    private LocalDate dataDesligamento;
    @NotNull
    private boolean ativo;

    @ManyToOne
    private Cargo cargo;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UnidadeSalarial unidadeSalarial = UnidadeSalarial.MENSAL;
    @NotNull
    private BigDecimal salarioAtual = BigDecimal.ZERO;

    @NotBlank
    private String numeroConta;
    @NotBlank
    private String agenciaConta;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;
    @NotBlank
    private String codigoBanco;
    @NotNull
    @OneToOne
    private Endereco endereco;

    @NotNull
    @ManyToOne
    private Empresa empresa;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, LocalDate dataNascimento, String cpf, String matricula, String telefone, String email, LocalDate dataAdmissao, UnidadeSalarial unidadeSalarial, BigDecimal salarioAtual, String numeroConta, String agenciaConta, TipoConta tipoConta, String codigoBanco, Cargo cargo, Empresa empresa, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.matricula = matricula;
        this.telefone = telefone;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
        this.unidadeSalarial = unidadeSalarial;
        this.salarioAtual = salarioAtual;
        this.numeroConta = numeroConta;
        this.agenciaConta = agenciaConta;
        this.tipoConta = tipoConta;
        this.codigoBanco = codigoBanco;
        this.cargo = cargo;
        this.empresa = empresa;
        this.endereco = endereco;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(LocalDate dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public UnidadeSalarial getUnidadesSalarial() {
        return unidadeSalarial;
    }

    public void setUnidadesSalarial(UnidadeSalarial unidadeSalarial) {
        this.unidadeSalarial = unidadeSalarial;
    }

    public BigDecimal getSalarioAtual() {
        return salarioAtual;
    }

    public void setSalarioAtual(BigDecimal salarioAtual) {
        this.salarioAtual = salarioAtual;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(String agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
