package com.gama.academy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 10)
    private String cbo;
    @Column(nullable = false)
    private String descricao;
    private BigDecimal pisoSalarial;
    private BigDecimal tetoSalarial;

    public Cargo() {
    }

    public Cargo(Long id, String cbo, String descricao, BigDecimal pisoSalarial, BigDecimal tetoSalarial) {
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

    public BigDecimal getPisoSalarial() {
        return pisoSalarial;
    }

    public void setPisoSalarial(BigDecimal pisoSalarial) {
        this.pisoSalarial = pisoSalarial;
    }

    public BigDecimal getTetoSalarial() {
        return tetoSalarial;
    }

    public void setTetoSalarial(BigDecimal tetoSalarial) {
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
