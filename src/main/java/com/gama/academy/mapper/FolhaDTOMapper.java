package com.gama.academy.mapper;

import com.gama.academy.dto.FolhaDTO;
import com.gama.academy.model.Folha;

public class FolhaDTOMapper {

    public static FolhaDTO toFolhaDTO(Folha folha){
        return new FolhaDTO(folha.getId(), FuncionarioResumoMapper.toFuncionarioResumo(folha.getFuncionario()),
                folha.getFuncionario().getEmpresa().getRazaoSocial(), folha.getFuncionario().getEmpresa().getCnpj(),
                folha.getTotalVencimento(), folha.getTotalDesconto(), folha.getSalarioLiquido(),
            folha.getFgts(), folha.getInss(), folha.getIrrf(), folha.getBaseIrrf(), folha.getBaseInss(), folha.getBaseFgts(),
            folha.getCompetencia());
    }

}
