package com.gama.academy.mapper;

import com.gama.academy.dto.EmpresaDTO;
import com.gama.academy.model.Empresa;

public class EmpresaMapper {

    public static Empresa toEmpresa(EmpresaDTO empresaDTO){
        return new Empresa(empresaDTO.getId(), empresaDTO.getNomeFantasia(), empresaDTO.getRazaoSocial(), empresaDTO.getCnpj(),
                empresaDTO.getEmail(), empresaDTO.getTelefone(), empresaDTO.getEndereco());
    }

    public static Empresa toEmpresaDTO(Empresa empresa){
        return new Empresa(empresa.getId(), empresa.getNomeFantasia(), empresa.getRazaoSocial(), empresa.getCnpj(),
                empresa.getEmail(), empresa.getTelefone(), empresa.getEndereco);
    }

}
