package com.gama.academy.enums;

public enum UnidadeSalarial {

    MENSAL("Mensal"),
    QUINZENAL("Quinzenal"),
    SEMANAL("Semanal"),
    DIARIA("Diária"),
    HORARIA("Horária");

    private String descricao;

    UnidadeSalarial(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
