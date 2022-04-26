package com.gama.academy.enums;

import java.math.BigDecimal;

public enum EnumFaixaInss {

    FAIXA_01(BigDecimal.valueOf(1212)),
    FAIXA_02(BigDecimal.valueOf(2427.25)),
    FAIXA_03(BigDecimal.valueOf(3641.03)),
    FAIXA_04(BigDecimal.valueOf(7087.22));

    private BigDecimal valor;

    private EnumFaixaInss(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor(){
        return valor;
    }
}
