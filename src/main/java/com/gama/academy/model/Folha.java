package com.gama.academy.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Folha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Funcionario funcionario;

    private BigDecimal totalVencimento;
    private BigDecimal totalDesconto;
    private BigDecimal salarioLiquido;
    private BigDecimal fgts;
    private BigDecimal inss;
    private BigDecimal irrf;
    private BigDecimal baseIrrf;
    private BigDecimal baseInss;
    private BigDecimal baseFgts;
    private BigDecimal salarioFamilia;
    private String competencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public BigDecimal getTotalVencimento() {
        return totalVencimento;
    }

    public void setTotalVencimento(BigDecimal totalVencimento) {
        this.totalVencimento = totalVencimento;
    }

    public BigDecimal getTotalDesconto() {
        return totalDesconto;
    }

    public void setTotalDesconto(BigDecimal totalDesconto) {
        this.totalDesconto = totalDesconto;
    }

    public BigDecimal getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(BigDecimal salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public BigDecimal getFgts() {
        return fgts;
    }

    public void setFgts(BigDecimal fgts) {
        this.fgts = fgts;
    }

    public BigDecimal getInss() {
        return inss;
    }

    public void setInss(BigDecimal inss) {
        this.inss = inss;
    }

    public BigDecimal getIrrf() {
        return irrf;
    }

    public void setIrrf(BigDecimal irrf) {
        this.irrf = irrf;
    }

    public BigDecimal getBaseIrrf() {
        return baseIrrf;
    }

    public void setBaseIrrf(BigDecimal baseIrrf) {
        this.baseIrrf = baseIrrf;
    }

    public BigDecimal getBaseInss() {
        return baseInss;
    }

    public void setBaseInss(BigDecimal baseInss) {
        this.baseInss = baseInss;
    }

    public BigDecimal getBaseFgts() {
        return baseFgts;
    }

    public void setBaseFgts(BigDecimal baseFgts) {
        this.baseFgts = baseFgts;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public BigDecimal getSalarioFamilia() {
        return salarioFamilia;
    }

    public void setSalarioFamilia(BigDecimal salarioFamilia) {
        this.salarioFamilia = salarioFamilia;
    }
}
