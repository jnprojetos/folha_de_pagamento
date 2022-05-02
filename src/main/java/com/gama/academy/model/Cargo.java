package com.gama.academy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cbo;
    private String descricao;
    private double pisoSalarial;
    private double tetoSalarial;

    public Cargo() {
    }

    public Cargo(Long id, String cbo, String descricao, double pisoSalarial, double tetoSalarial) {
        this.id = id;
        this.cbo = cbo;
        this.descricao = descricao;
        this.pisoSalarial = pisoSalarial;
        this.tetoSalarial = tetoSalarial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPisoSalarial() {
        return pisoSalarial;
    }

    public void setPisoSalarial(double pisoSalarial) {
        this.pisoSalarial = pisoSalarial;
    }

    public double getTetoSalarial() {
        return tetoSalarial;
    }

    public void setTetoSalarial(double tetoSalarial) {
        this.tetoSalarial = tetoSalarial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(id, cargo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
