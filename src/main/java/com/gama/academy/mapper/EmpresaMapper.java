package com.gama.academy.mapper;

import com.gama.academy.dto.EmpresaDTO;
import com.gama.academy.model.Empresa;

public class EmpresaMapper {

    public static Empresa toEmpresa(EmpresaDTO empresaDTO){
        return new Empresa(empresaDTO.getId(), empresaDTO.getNomeFantasia(), empresaDTO.getRazaoSocial(), empresaDTO.getCnpj(),
                empresaDTO.getEmail(), empresaDTO.getTelefone(), EnderecoMapper.toEndereco(empresaDTO.getEndereco()));
    }

    public static EmpresaDTO toEmpresaDTO(Empresa empresa){
        return new EmpresaDTO(empresa.getId(), empresa.getNomeFantasia(), empresa.getRazaoSocial(), empresa.getCnpj(),
                empresa.getEmail(), empresa.getTelefone(), EnderecoMapper.toEnderecoDTO(empresa.getEndereco()));
    }

}
