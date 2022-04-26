package com.gama.academy.model;

import com.gama.academy.enums.EnumTipoRubrica;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Rubrica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private EnumTipoRubrica tipo;

    private BigDecimal referencia;


    public Rubrica(){};

    public Rubrica(Long id, String descricao, EnumTipoRubrica tipo, BigDecimal referencia) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.referencia = referencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnumTipoRubrica getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoRubrica tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getReferencia() {
        return referencia;
    }

    public void setReferencia(BigDecimal referencia) {
        this.referencia = referencia;
    }
}
