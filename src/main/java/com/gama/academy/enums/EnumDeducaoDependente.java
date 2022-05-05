package com.gama.academy.enums;

import java.math.BigDecimal;

public enum EnumDeducaoDependente {

    DEDUCAO_POR_DEPENDENTE(BigDecimal.valueOf(189.59));

    private BigDecimal valor;

    private EnumDeducaoDependente(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor(){
        return valor;
    }
}
