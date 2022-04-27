package com.gama.academy.mapper;

import com.gama.academy.dto.EnderecoDTO;
import com.gama.academy.model.Endereco;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoMapper {

    public static Endereco toEndereco(EnderecoDTO dto){
        return new Endereco(dto.getId(), dto.getLogradouro(), dto.getNumero(), dto.getComplemento(), dto.getBairro(),
            dto.getCidade(), dto.getUf(), dto.getPais());
    }

    public static EnderecoDTO toEnderecoDTO(Endereco endereco){
        return new EnderecoDTO(endereco.getId(), endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(),
            endereco.getCidade(), endereco.getUf(), endereco.getPais());
    }

    public static List<EnderecoDTO> toListEnderecoDTO(List<Endereco> enderecos){
       if(enderecos != null){
          return enderecos.stream().map(endereco -> toEnderecoDTO(endereco)).collect(Collectors.toList());
       }
       return null;
    }
}
