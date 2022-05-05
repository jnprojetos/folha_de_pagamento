package com.gama.academy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class AlteracaoSalarial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataAlteracao;

    @NotBlank(message = "Informe o motivo")
    private String motivo;

    @NotNull(message = "Informe o novo salario")
    private BigDecimal novoSalario;

    @NotNull(message = "Informe o funcionario")

    @JsonIgnore
    @ManyToOne
    private Funcionario funcionario;

    public AlteracaoSalarial(){

    }

    public AlteracaoSalarial(Long id, LocalDate dataAlteracao, String motivo, BigDecimal novoSalario, Funcionario funcionario) {
        this.id = id;
        this.dataAlteracao = dataAlteracao;
        this.motivo = motivo;
        this.novoSalario = novoSalario;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getMotivo() {
        return motivo;
    }

    public BigDecimal getNovoSalario() {
        return novoSalario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
