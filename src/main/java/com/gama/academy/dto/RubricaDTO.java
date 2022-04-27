package com.gama.academy.dto;

import com.gama.academy.enums.EnumTipoRubrica;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RubricaDTO {

    private Long id;
    @NotBlank(message = "Descrição obrigatoria")
    private String descricao;

    @NotBlank(message = "Tipo obrigatorio")
    private EnumTipoRubrica tipo;

    @NotNull(message = "Referencia obrigatorio")
    private BigDecimal referencia;

    private BigDecimal adiconalHora;

    public RubricaDTO(Long id, String descricao, EnumTipoRubrica tipo, BigDecimal referencia, BigDecimal adiconalHora) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.referencia = referencia;
        this.adiconalHora = adiconalHora;
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

    public BigDecimal getAdiconalHora() {
        return adiconalHora;
    }

    public void setAdiconalHora(BigDecimal adiconalHora) {
        this.adiconalHora = adiconalHora;
    }
}
