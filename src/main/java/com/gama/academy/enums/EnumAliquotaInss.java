package com.gama.academy.enums;

import java.math.BigDecimal;

public enum EnumAliquotaInss {
    SETE_MEIO(BigDecimal.valueOf(0.075)),
    NOVE(BigDecimal.valueOf(0.09)),
    DOZE(BigDecimal.valueOf(0.12)),
    QUATORZE(BigDecimal.valueOf(0.14));

    private BigDecimal valor;

    private EnumAliquotaInss(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor(){
        return valor;
    }
}
