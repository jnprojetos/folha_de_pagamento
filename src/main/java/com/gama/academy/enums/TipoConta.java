package com.gama.academy.enums;

public enum TipoConta {

    CORRENTE("Corrente"),
    SALARIO("Salário"),
    POUPANCA("Poupança");

    private String descricao;

    TipoConta(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
