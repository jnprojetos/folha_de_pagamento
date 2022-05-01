package com.gama.academy.dto;

import com.gama.academy.enums.TipoConta;
import com.gama.academy.enums.UnidadeSalarial;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioDTO {

    private Long id;

    @NotBlank(message = "É necessário informar o nome")
    private String nome;
    @NotNull(message = "É necessário informar a data de nascimento")
    private LocalDate dataNascimento;
    @NotBlank(message = "É necessário informar o cpf")
    private String cpf;
    @NotBlank(message = "É necessário informar a matrícula")
    private String matricula;
    @NotBlank(message = "É necessário informar o telefone")
    private String telefone;
    @NotBlank(message = "É necessário informar o e-mail")
    private String email;
    @NotNull(message = "É necessário informar a data de admissão")
    private LocalDate dataAdmissao;
    private LocalDate dataDesligamento;
    @NotNull(message = "É necessário informar o status")
    private boolean ativo = true;

    /*@NotNull(message = "É necessário informar o cargo do funcionario")
    private Long idCargo;*/
    @NotNull (message = "É necessário informar a unidade salarial")
    @Enumerated(EnumType.STRING)
    private UnidadeSalarial unidadeSalarial = UnidadeSalarial.MENSAL;
    @NotNull(message = "É necessário informar o salário atual")
    private BigDecimal salarioAtual = BigDecimal.ZERO;

    @NotBlank(message = "É necessário informar o número da conta")
    private String numeroConta;
    @NotBlank(message = "É necessário informar a agência da conta")
    private String agenciaConta;
    @NotNull (message = "É necessário informar o tipo da conta")
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;
    @NotBlank(message = "É necessário informar o código do banco")
    private String codigoBanco;

    public FuncionarioDTO(Long id, String nome, LocalDate dataNascimento, String cpf, String matricula, String telefone, String email, LocalDate dataAdmissao,
                          boolean ativo, UnidadeSalarial unidadeSalarial, BigDecimal salarioAtual, String numeroConta, String agenciaConta, TipoConta tipoConta, String codigoBanco) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.matricula = matricula;
        this.telefone = telefone;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
        this.ativo = ativo;
        this.unidadeSalarial = unidadeSalarial;
        this.salarioAtual = salarioAtual;
        this.numeroConta = numeroConta;
        this.agenciaConta = agenciaConta;
        this.tipoConta = tipoConta;
        this.codigoBanco = codigoBanco;
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
}
