package com.gama.academy.model;

import com.gama.academy.enums.EnumAliquotaInss;
import com.gama.academy.enums.EnumFaixaInss;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class Inss {

    public BigDecimal calcularInss(BigDecimal baseDeCalculo){

        BigDecimal diferenca = BigDecimal.ZERO;
        List<BigDecimal> totalInss = new ArrayList<>();

        while(baseDeCalculo.compareTo(BigDecimal.ZERO) > 0) {
            if(baseDeCalculo.compareTo(EnumFaixaInss.FAIXA_04.getValor()) > 0) {
                baseDeCalculo = EnumFaixaInss.FAIXA_04.getValor();
            }else if(baseDeCalculo.compareTo(EnumFaixaInss.FAIXA_03.getValor()) > 0 && baseDeCalculo.compareTo(EnumFaixaInss.FAIXA_04.getValor()) <= 0){
                diferenca = baseDeCalculo.subtract(EnumFaixaInss.FAIXA_03.getValor());
                totalInss.add(diferenca.multiply(EnumAliquotaInss.QUATORZE.getValor()));
                baseDeCalculo = baseDeCalculo.subtract(diferenca).setScale(2, RoundingMode.HALF_EVEN);
            }else if(baseDeCalculo.compareTo(EnumFaixaInss.FAIXA_02.getValor()) > 0 && baseDeCalculo.compareTo(EnumFaixaInss.FAIXA_03.getValor()) <= 0){
                diferenca = baseDeCalculo.subtract(EnumFaixaInss.FAIXA_02.getValor());
                totalInss.add(diferenca.multiply(EnumAliquotaInss.DOZE.getValor()));
                baseDeCalculo = baseDeCalculo.subtract(diferenca).setScale(2, RoundingMode.HALF_EVEN);;
            }else if(baseDeCalculo.compareTo(EnumFaixaInss.FAIXA_01.getValor()) > 0 && baseDeCalculo.compareTo(EnumFaixaInss.FAIXA_02.getValor()) <= 0) {
                diferenca = baseDeCalculo.subtract(EnumFaixaInss.FAIXA_01.getValor());
                totalInss.add(diferenca.multiply(EnumAliquotaInss.NOVE.getValor()));
                baseDeCalculo = baseDeCalculo.subtract(diferenca).setScale(2, RoundingMode.HALF_EVEN);
            }else{
                totalInss.add(baseDeCalculo.multiply(EnumAliquotaInss.SETE_MEIO.getValor()));
                baseDeCalculo = baseDeCalculo.subtract(baseDeCalculo).setScale(2, RoundingMode.HALF_EVEN);
            }
        }
        return totalInss.stream().reduce(BigDecimal.valueOf(0), BigDecimal::add).setScale(2, RoundingMode.HALF_EVEN);
    }
}
