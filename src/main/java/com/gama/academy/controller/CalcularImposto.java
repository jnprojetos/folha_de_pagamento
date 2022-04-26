package com.gama.academy.controller;

import com.gama.academy.model.Fgts;
import com.gama.academy.model.ImpostoDeRenda;
import com.gama.academy.model.Inss;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/impostos")
public class CalcularImposto {


    @PostMapping("/irrf/{salario}")
    public BigDecimal calcularIrrf(@PathVariable BigDecimal salario){
        ImpostoDeRenda ir = new ImpostoDeRenda();
        BigDecimal valor = ir.calcularImpostoRenda(salario);
        return valor;
    }

    @PostMapping("/inss/{salario}")
    public BigDecimal calcularInss(@PathVariable BigDecimal salario){
        Inss inss = new Inss();
        BigDecimal valor = inss.calcularInss(salario);
        return valor;
    }

    @PostMapping("/fgts/{salario}")
    public BigDecimal calcularFgts(@PathVariable BigDecimal salario){
        Fgts fgts = new Fgts();
        BigDecimal valor = fgts.calcularFgts(salario);
        return valor;
    }

}
