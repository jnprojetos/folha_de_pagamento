package com.gama.academy.model;

import com.gama.academy.enums.EnumAliquotaIR;
import com.gama.academy.enums.EnumDeducaoImpostoRenda;
import com.gama.academy.enums.EnumFaixaImpostoRenda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImpostoDeRenda {

    private BigDecimal totalImpostoRenda;

    public BigDecimal calcularImpostoRenda(BigDecimal baseDeCalculo){

        if(baseDeCalculo.compareTo(EnumFaixaImpostoRenda.FAIXA_01.getValor()) > 0){
            this.totalImpostoRenda = baseDeCalculo.multiply(EnumAliquotaIR.VINTE_SETE_MEIO.getValor()).subtract(EnumDeducaoImpostoRenda.FAIXA_04.getValor());
        }
        if (baseDeCalculo.compareTo(EnumFaixaImpostoRenda.FAIXA_01.getValor()) < 0){
            this.totalImpostoRenda = baseDeCalculo.multiply(EnumAliquotaIR.VINTE_DOIS_MEIO.getValor()).subtract(EnumDeducaoImpostoRenda.FAIXA_03.getValor());
        }
        if (baseDeCalculo.compareTo(EnumFaixaImpostoRenda.FAIXA_02.getValor()) < 0){
            this.totalImpostoRenda = baseDeCalculo.multiply(EnumAliquotaIR.QUINZE.getValor()).subtract(EnumDeducaoImpostoRenda.FAIXA_02.getValor());
        }
        if (baseDeCalculo.compareTo(EnumFaixaImpostoRenda.FAIXA_03.getValor()) < 0){
            this.totalImpostoRenda = baseDeCalculo.multiply(EnumAliquotaIR.SETE_MEIO.getValor()).subtract(EnumDeducaoImpostoRenda.FAIXA_01.getValor());
        }
        if (baseDeCalculo.compareTo(EnumFaixaImpostoRenda.FAIXA_04.getValor()) < 0){
            this.totalImpostoRenda = baseDeCalculo.multiply(EnumAliquotaIR.ISENTO.getValor());
        }
        return totalImpostoRenda.setScale(2, RoundingMode.HALF_EVEN);
    }
}
