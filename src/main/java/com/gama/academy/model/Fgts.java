package com.gama.academy.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Fgts {
    public BigDecimal calcularFgts(BigDecimal baseDeCalculo){
        return baseDeCalculo.multiply(BigDecimal.valueOf(0.08)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
