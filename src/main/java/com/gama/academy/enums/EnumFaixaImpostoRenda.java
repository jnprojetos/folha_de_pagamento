package com.gama.academy.enums;

import java.math.BigDecimal;

public enum EnumFaixaImpostoRenda {

    FAIXA_01(BigDecimal.valueOf(4664.68)),
    FAIXA_02(BigDecimal.valueOf(3751.05)),
    FAIXA_03(BigDecimal.valueOf(2826.65)),
    FAIXA_04(BigDecimal.valueOf(1903.98));

    private BigDecimal valor;

    private EnumFaixaImpostoRenda(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor(){
        return valor;
    }
}
