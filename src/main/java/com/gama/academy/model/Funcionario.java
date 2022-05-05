package com.gama.academy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataAdmissao;
    private LocalDate dataDesligamento;
    private boolean ativo;

    @ManyToOne
    private Cargo cargo;
    private BigDecimal salarioAtual;
    @OneToOne
    private Endereco endereco;
    @ManyToOne
    private Empresa empresa;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, LocalDate dataNascimento, String cpf, String telefone, String email,
                       LocalDate dataAdmissao, Cargo cargo, BigDecimal salarioAtual, Endereco endereco,
                       Empresa empresa) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.salarioAtual = salarioAtual;
        this.endereco = endereco;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public LocalDate getDataDesligamento() {
        return dataDesligamento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public BigDecimal getSalarioAtual() {
        return salarioAtual;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void admitir(){
        this.ativo = true;
    }

    public void demitir(){
        this.ativo = false;
        this.dataDesligamento = LocalDate.now();
    }
    public void alterarSalario(BigDecimal novoSalario){
        this.salarioAtual = novoSalario;
    }
}
