package com.gama.academy.mapper;

import com.gama.academy.dto.FuncionarioResumo;
import com.gama.academy.model.Funcionario;

public class FuncionarioResumoMapper {

    public static FuncionarioResumo toFuncionarioResumo(Funcionario funcionario){
        return new FuncionarioResumo(funcionario.getId(), funcionario.getNome(), funcionario.getCargo().getCbo(), funcionario.getCargo().getDescricao(), funcionario.getSalarioAtual());
    }
}
