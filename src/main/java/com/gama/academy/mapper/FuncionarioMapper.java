package com.gama.academy.mapper;

import com.gama.academy.dto.FuncionarioDTO;
import com.gama.academy.model.Funcionario;

import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioMapper {

    public static Funcionario toFuncionario(FuncionarioDTO dto){
        return new Funcionario(dto.getId(), dto.getNome(), dto.getDataNascimento(), dto.getCpf(), dto.getMatricula(), dto.getTelefone(), dto.getEmail(), dto.getDataAdmissao(),
        dto.isAtivo(), dto.getUnidadeSalarial(), dto.getSalarioAtual(), dto.getNumeroConta(), dto.getAgenciaConta(), dto.getTipoConta(), dto.getCodigoBanco());
    }

    public static FuncionarioDTO toFuncionarioDTO(Funcionario funcionario){
        return new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getCpf(), funcionario.getMatricula(), funcionario.getTelefone(), funcionario.getEmail(), funcionario.getDataAdmissao(),
            funcionario.isAtivo(), funcionario.getUnidadesSalarial(), funcionario.getSalarioAtual(), funcionario.getNumeroConta(), funcionario.getAgenciaConta(), funcionario.getTipoConta(), funcionario.getCodigoBanco(), funcionario.getCargo());
    }

    public static List<FuncionarioDTO> toListFuncionarioDTO(List<Funcionario> funcionarios){
       if(funcionarios != null){
          return funcionarios.stream().map(endereco -> toFuncionarioDTO(endereco)).collect(Collectors.toList());
       }
       return null;
    }
}
