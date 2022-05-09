package com.gama.academy.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class DependenteDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @CPF(message = "Informa um cpf válido")
    private String cpf;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Informa uma data de nascimento válida")
    private LocalDate dataNascimento;

    private FuncionarioDTO funcionario;

    public DependenteDTO(Long id, String nome, String cpf, LocalDate dataNascimento, FuncionarioDTO funcionario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.funcionario = funcionario;
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

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }
}
