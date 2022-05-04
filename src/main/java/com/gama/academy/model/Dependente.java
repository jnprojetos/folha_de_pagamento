package com.gama.academy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Funcionario funcinario;

    public Dependente(){};

    public Dependente(Long id, String nome, String cpf, LocalDate dataNascimento, Funcionario funcionario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.funcinario = funcionario;
    }

    public Long getId() {
        return id;
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

    public Funcionario getFuncinario() {
        return funcinario;
    }

    public void setFuncinario(Funcionario funcinario) {
        this.funcinario = funcinario;
    }

    public int calculaIdade(LocalDate dataNascimento){
        Period idade = Period.between(LocalDate.now(), dataNascimento);
        return idade.getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependente that = (Dependente) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
