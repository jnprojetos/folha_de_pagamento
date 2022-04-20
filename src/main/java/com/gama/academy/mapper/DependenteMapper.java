package com.gama.academy.mapper;

import com.gama.academy.dto.DependenteDTO;
import com.gama.academy.model.Dependente;

public class DependenteMapper {

    public static Dependente toDependente(DependenteDTO dependenteDTO){
        return new Dependente(null, dependenteDTO.getNome(), dependenteDTO.getCpf(), dependenteDTO.getDataNascimento());
    }

    public static DependenteDTO toDependenteDTO(Dependente dependente){
        return new DependenteDTO(dependente.getId(), dependente.getNome(), dependente.getCpf(), dependente.getDataNascimento());
    }
}
