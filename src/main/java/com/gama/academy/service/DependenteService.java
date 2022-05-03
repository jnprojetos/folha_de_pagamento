package com.gama.academy.service;

import com.gama.academy.dto.DependenteDTO;
import com.gama.academy.mapper.DependenteMapper;
import com.gama.academy.model.Dependente;
import com.gama.academy.repository.DependenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    public Page<DependenteDTO> listarTodos(Pageable pageable){
        return dependenteRepository.findAll(pageable)
                .map(dependente -> DependenteMapper.toDependenteDTO(dependente));
    }

    public DependenteDTO novoDependente(DependenteDTO dependenteDTO){
        Dependente dependente = dependenteRepository.save(DependenteMapper.toDependente(dependenteDTO));
        return DependenteMapper.toDependenteDTO(dependente);
    }

    public DependenteDTO alterar(Long id, DependenteDTO dependenteDTO){
        Dependente dependente = dependenteRepository.findById(id).orElseThrow(()-> new RuntimeException("Dependente não encontrado"));
        dependenteDTO.setId(dependente.getId());
        return DependenteMapper.toDependenteDTO(dependenteRepository.save(DependenteMapper.toDependente(dependenteDTO)));
    }

    public void excluir(Long id){
        Dependente dependente = dependenteRepository.findById(id).orElseThrow(()-> new RuntimeException("Dependente não encontrado"));
        dependenteRepository.delete(dependente);
    }
}
