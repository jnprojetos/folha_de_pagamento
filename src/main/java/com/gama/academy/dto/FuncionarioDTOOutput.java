package com.gama.academy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioDTOOutput {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataAdmissao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate dataDesligamento;
    private boolean ativo;
    private CargoDTO cargo;
    private BigDecimal salario;
    private EmpresaDTO empresa;
    private EnderecoDTO endereco;

    public FuncionarioDTOOutput(Long id, String nome, LocalDate dataNascimento, String cpf, String telefone,
                                String email, LocalDate dataAdmissao, LocalDate dataDesligamento,
                                boolean ativo, CargoDTO cargo, BigDecimal salario, EmpresaDTO empresa, EnderecoDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
        this.dataDesligamento = dataDesligamento;
        this.ativo = ativo;
        this.cargo = cargo;
        this.salario = salario;
        this.empresa = empresa;
        this.endereco = endereco;
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

    public CargoDTO getCargo() {
        return cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }
}
