package com.gama.academy.dto;

import com.gama.academy.enums.TipoRubrica;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RubricaDTO {

    private Long id;
    @NotBlank(message = "Descrição obrigatoria")
    private String descricao;

    @NotBlank(message = "Tipo obrigatorio")
    private TipoRubrica tipo;

    @NotNull(message = "Referencia obrigatorio")
    private BigDecimal referencia;

    public RubricaDTO(Long id, String descricao, TipoRubrica tipo, BigDecimal referencia) {
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

    public TipoRubrica getTipo() {
        return tipo;
    }

    public void setTipo(TipoRubrica tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getReferencia() {
        return referencia;
    }

    public void setReferencia(BigDecimal referencia) {
        this.referencia = referencia;
    }
}
