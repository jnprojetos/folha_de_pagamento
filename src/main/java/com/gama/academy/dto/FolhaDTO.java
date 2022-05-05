package com.gama.academy.dto;

import java.math.BigDecimal;

public class FolhaDTO {

    private Long id;
    private FuncionarioResumo funcionario;
    private String razaoSocial;
    private String cnpj;
    private BigDecimal totalVencimento;
    private BigDecimal totalDesconto;
    private BigDecimal salarioLiquido;
    private BigDecimal fgts;
    private BigDecimal inss;
    private BigDecimal irrf;
    private BigDecimal baseIrrf;
    private BigDecimal baseInss;
    private BigDecimal baseFgts;
    private String competencia;

    public FolhaDTO(Long id, FuncionarioResumo funcionario, String razaoSocial, String cnpj,
                    BigDecimal totalVencimento, BigDecimal totalDesconto, BigDecimal salarioLiquido,
                    BigDecimal fgts, BigDecimal inss, BigDecimal irrf, BigDecimal baseIrrf,
                    BigDecimal baseInss, BigDecimal baseFgts, String competencia) {
        this.id = id;
        this.funcionario = funcionario;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.totalVencimento = totalVencimento;
        this.totalDesconto = totalDesconto;
        this.salarioLiquido = salarioLiquido;
        this.fgts = fgts;
        this.inss = inss;
        this.irrf = irrf;
        this.baseIrrf = baseIrrf;
        this.baseInss = baseInss;
        this.baseFgts = baseFgts;
        this.competencia = competencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FuncionarioResumo getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioResumo funcionario) {
        this.funcionario = funcionario;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
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
}
