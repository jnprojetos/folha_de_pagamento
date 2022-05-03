package com.gama.academy.service;

import com.gama.academy.dto.EnderecoDTO;
import com.gama.academy.exception.EntidadeNaoEncontradaException;
import com.gama.academy.mapper.EnderecoMapper;
import com.gama.academy.model.Cargo;
import com.gama.academy.model.Endereco;
import com.gama.academy.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    public EnderecoDTO salvar(EnderecoDTO dto) {
        Endereco endereco = repository.save(EnderecoMapper.toEndereco(dto));
        return EnderecoMapper.toEnderecoDTO(endereco);
    }

    public EnderecoDTO alterar(Long id, EnderecoDTO dto){
        Endereco endereco = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Endereço não encontrado."));
        dto.setId(endereco.getId());
        return salvar(dto);
    }

    public EnderecoDTO excluir(Long id){
        Endereco endereco = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Endereço não encontrado."));
        repository.delete(endereco);
        return EnderecoMapper.toEnderecoDTO(endereco);
    }

    public List<EnderecoDTO> listar(){
      return EnderecoMapper.toListEnderecoDTO(repository.findAll());
    }

    public Endereco findById(Long id){
        Optional<Endereco> endereco = repository.findById(id);
        if(endereco.isPresent()){
            return endereco.get();
        }
        return null;
    }
}
