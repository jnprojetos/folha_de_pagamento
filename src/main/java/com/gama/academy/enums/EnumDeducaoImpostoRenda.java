package com.gama.academy.enums;

import java.math.BigDecimal;

public enum EnumDeducaoImpostoRenda {

    FAIXA_01(BigDecimal.valueOf(142.80)),
    FAIXA_02(BigDecimal.valueOf(354.80)),
    FAIXA_03(BigDecimal.valueOf(636.13)),
    FAIXA_04(BigDecimal.valueOf(869.36));

    private BigDecimal valor;

    private EnumDeducaoImpostoRenda(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor(){
        return valor;
    }
}
