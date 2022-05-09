package com.gama.academy.dto;

import java.time.LocalDate;

public class DependenteResumo {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public DependenteResumo(Long id, String nome, String cpf, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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
}
