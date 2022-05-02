package com.gama.academy.enums;

public enum EnumTipoLancamento {

    VENCIMENTO("Vencimento"),
    DESCONTO("Desconto");

    EnumTipoLancamento(String descricao) {
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
