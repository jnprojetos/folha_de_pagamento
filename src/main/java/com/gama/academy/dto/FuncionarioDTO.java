package com.gama.academy.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioDTO {

    private Long id;

    @NotBlank(message = "É necessário informar o nome")
    private String nome;

    @NotNull(message = "É necessário informar a data de nascimento")
    @Future(message = "Data de nascimento inválida")
    private LocalDate dataNascimento;

    @NotBlank(message = "É necessário informar o cpf")
    @CPF(message = "CPF Inválido")
    private String cpf;

    @NotBlank(message = "É necessário informar o telefone")
    private String telefone;

    @NotBlank(message = "É necessário informar o e-mail")
    private String email;

    @NotNull(message = "É necessário informar a data de admissão")
    private LocalDate dataAdmissao;

    @NotNull(message = "É necessário informar o cargo do funcionario")
    private CargoDTO cargo;

    @NotNull(message = "É necessário informar o salário atual")
    @Min(value = 1, message = "O salário não pode ser menor ou igual a zero")
    private BigDecimal salarioAtual;

    @NotNull(message = "É necessário informar a empresa do funcionário")
    private EmpresaDTO empresa;

    @NotNull(message = "É necessário informar o endereço do funcionário")
    private EnderecoDTO endereco;

    public FuncionarioDTO(Long id, String nome, LocalDate dataNascimento, String cpf, String telefone,
                          String email, LocalDate dataAdmissao, CargoDTO cargo, BigDecimal salarioAtual,
                          EmpresaDTO empresa, EnderecoDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.salarioAtual = salarioAtual;
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

    public CargoDTO getCargo() {
        return cargo;
    }

    public BigDecimal getSalarioAtual() {
        return salarioAtual;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCargo(CargoDTO cargo) {
        this.cargo = cargo;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
