package com.gama.academy.service;

import com.gama.academy.dto.FuncionarioDTO;
import com.gama.academy.exception.EntidadeNaoEncontradaException;
import com.gama.academy.mapper.FuncionarioMapper;
import com.gama.academy.model.Funcionario;
import com.gama.academy.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    public FuncionarioDTO salvar(FuncionarioDTO dto) {
        Funcionario funcionario = repository.save(FuncionarioMapper.toFuncionario(dto));
        return FuncionarioMapper.toFuncionarioDTO(funcionario);
    }

    public FuncionarioDTO alterar(Long id, FuncionarioDTO dto){
        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Endereço não encontrado."));
        dto.setId(funcionario.getId());
        return salvar(dto);
    }

    public FuncionarioDTO excluir(Long id){
        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Endereço não encontrado."));
        repository.delete(funcionario);
        return FuncionarioMapper.toFuncionarioDTO(funcionario);
    }

    public List<FuncionarioDTO> listar(){
        return FuncionarioMapper.toListFuncionarioDTO(repository.findAll());
    }
}
