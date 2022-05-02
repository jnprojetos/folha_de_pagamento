package com.gama.academy.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CargoDTO {

    private static Long id;

    @NotBlank(message = "CBO é obrigatório")
    private String cbo;

    @NotBlank(message = "Descrição obrigatória")
    private String descricao;

    @NotNull(message = "Piso salarial")
    private BigDecimal pisoSalarial;

    @NotNull(message = "Teto salarial")
    private BigDecimal tetoSalarial;

    public CargoDTO(Long id, String cbo, String descricao, BigDecimal pisoSalarial, BigDecimal tetoSalarial) {
        this.id = id;
        this.cbo = cbo;
        this.descricao = descricao;
        this.pisoSalarial = pisoSalarial;
        this.tetoSalarial = tetoSalarial;
    }

    public static Long getId() { return id; }

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
}
