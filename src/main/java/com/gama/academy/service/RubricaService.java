package com.gama.academy.service;

import com.gama.academy.dto.RubricaDTO;
import com.gama.academy.mapper.RubricaMapper;
import com.gama.academy.model.Rubrica;
import com.gama.academy.repository.RubricaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RubricaService {

    @Autowired
    private RubricaRepository rubricaRepository;

    public RubricaDTO novaRubrica(RubricaDTO rubricaDTO){
        return RubricaMapper.toRubricaDTO(rubricaRepository.save(RubricaMapper.toRubrica(rubricaDTO)));
    }

    public List<RubricaDTO> listar(){
        return rubricaRepository.findAll()
                .stream().map(rubrica -> RubricaMapper.toRubricaDTO(rubrica)).collect(Collectors.toList());
    }

    public RubricaDTO buscarPorId(Long id){
        return RubricaMapper.toRubricaDTO(rubricaRepository.findById(id).orElseThrow(()-> new RuntimeException("Rubrica não encontrada")));
    }

    public RubricaDTO alterar(Long id, RubricaDTO rubricaDTO){
        Rubrica rubrica = rubricaRepository.findById(id).get();
        BeanUtils.copyProperties(rubricaDTO, Rubrica.class);
        rubrica.setId(rubrica.getId());
        return RubricaMapper.toRubricaDTO(rubricaRepository.save(rubrica));
    }

    public void excluir(Long id){
        boolean existeRubrica = rubricaRepository.existsById(id);
        if (!existeRubrica){
            throw new RuntimeException("Rubrica não encontrada");
        }
        rubricaRepository.deleteById(id);
    }
}
