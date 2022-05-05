package com.gama.academy.mapper;

import com.gama.academy.dto.FuncionarioDTO;
import com.gama.academy.dto.FuncionarioDTOOutput;
import com.gama.academy.model.Funcionario;

public class FuncionarioMapper {

    public static Funcionario toFuncionario(FuncionarioDTO dto){
        return new Funcionario(dto.getId(), dto.getNome(), dto.getDataNascimento(), dto.getCpf(),
                dto.getTelefone(), dto.getEmail(), dto.getDataAdmissao(),
                CargoMapper.toCargo(dto.getCargo()), dto.getSalarioAtual(),
                EnderecoMapper.toEndereco(dto.getEndereco()), EmpresaMapper.toEmpresa(dto.getEmpresa()));
    }

    public static FuncionarioDTOOutput toFuncionarioOutput(Funcionario funcionario){
        return new FuncionarioDTOOutput(
                funcionario.getId(), funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getCpf(),
                funcionario.getTelefone(), funcionario.getEmail(), funcionario.getDataAdmissao(), funcionario.getDataDesligamento(),
                funcionario.isAtivo(), CargoMapper.toCargoDTO(funcionario.getCargo()), funcionario.getSalarioAtual(),
                EmpresaMapper.toEmpresaDTO(funcionario.getEmpresa()),
                EnderecoMapper.toEnderecoDTO(funcionario.getEndereco()));
    }

    public static Funcionario funcionarioOutputToFuncionario(FuncionarioDTOOutput dtoOutput){
        return new Funcionario(
                dtoOutput.getId(), dtoOutput.getNome(), dtoOutput.getDataNascimento(), dtoOutput.getCpf(), dtoOutput.getTelefone(),
                dtoOutput.getEmail(), dtoOutput.getDataAdmissao(), CargoMapper.toCargo(dtoOutput.getCargo()), dtoOutput.getSalario(),
                EnderecoMapper.toEndereco(dtoOutput.getEndereco()), EmpresaMapper.toEmpresa(dtoOutput.getEmpresa())
        );
    }

    public static FuncionarioDTO toFuncionarioDTO(Funcionario funcionario) {
        return new FuncionarioDTO(
                funcionario.getId(), funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getCpf(),
                funcionario.getTelefone(), funcionario.getEmail(), funcionario.getDataAdmissao(), CargoMapper.toCargoDTO(funcionario.getCargo()),
                funcionario.getSalarioAtual(), EmpresaMapper.toEmpresaDTO(funcionario.getEmpresa()), EnderecoMapper.toEnderecoDTO(funcionario.getEndereco())
        );
    }
}
