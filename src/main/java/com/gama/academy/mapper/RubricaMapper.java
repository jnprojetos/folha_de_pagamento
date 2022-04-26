package com.gama.academy.mapper;

import com.gama.academy.dto.RubricaDTO;
import com.gama.academy.model.Rubrica;

public class RubricaMapper {

    public static Rubrica toRubrica(RubricaDTO rubricaDTO){
        return new Rubrica(rubricaDTO.getId(), rubricaDTO.getDescricao(), rubricaDTO.getTipo(), rubricaDTO.getReferencia());
    }

    public static RubricaDTO toRubricaDTO(Rubrica rubrica){
        return new RubricaDTO(rubrica.getId(), rubrica.getDescricao(), rubrica.getTipo(), rubrica.getReferencia());
    }
}
