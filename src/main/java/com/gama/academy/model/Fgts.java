package com.gama.academy.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class Fgts {
    public BigDecimal calcularFgts(BigDecimal baseDeCalculo){
        return baseDeCalculo.multiply(BigDecimal.valueOf(0.08)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
