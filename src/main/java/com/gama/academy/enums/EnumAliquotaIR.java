package com.gama.academy.enums;

import java.math.BigDecimal;

public enum EnumAliquotaIR {
    ISENTO(BigDecimal.ZERO),
    SETE_MEIO(BigDecimal.valueOf(0.075)),
    QUINZE(BigDecimal.valueOf(0.15)),
    VINTE_DOIS_MEIO(BigDecimal.valueOf(0.225)),
    VINTE_SETE_MEIO(BigDecimal.valueOf(0.275));

    private BigDecimal valor;

    private EnumAliquotaIR(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor(){
        return valor;
    }
}
