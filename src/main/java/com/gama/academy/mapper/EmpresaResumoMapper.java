package com.gama.academy.mapper;

import com.gama.academy.dto.EmpresaResumo;
import com.gama.academy.model.Empresa;

public class EmpresaResumoMapper {

    public static EmpresaResumo toEmpresaResumo(Empresa empresa){
        return new EmpresaResumo(empresa.getRazaoSocial(), empresa.getCnpj());
    }
}
