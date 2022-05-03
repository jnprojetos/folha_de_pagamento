package com.gama.academy.dto;

import java.math.BigDecimal;

public class FuncionarioResumo {

    private Long id;
    private String nome;
    private String cbo;
    private String cargo;
    private BigDecimal salario;

    public FuncionarioResumo(Long id, String nome, String cbo, String cargo, BigDecimal salario) {
        this.id = id;
        this.nome = nome;
        this.cbo = cbo;
        this.cargo = cargo;
        this.salario = salario;
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

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
