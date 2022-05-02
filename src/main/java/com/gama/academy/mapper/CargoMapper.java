package com.gama.academy.mapper;


import com.gama.academy.dto.CargoDTO;
import com.gama.academy.model.Cargo;

public class CargoMapper {

    public static Cargo toCargo(CargoDTO cargoDTO){
        return new Cargo(CargoDTO.getId(), cargoDTO.getCbo(), cargoDTO.getDescricao(), cargoDTO.getPisoSalarial(), cargoDTO.getTetoSalarial());
    }

    public static CargoDTO toCargoDTO(Cargo cargo){
        return new CargoDTO(cargo.getId(), cargo.getCbo(), cargo.getDescricao(), cargo.getPisoSalarial(), cargo.getTetoSalarial());
    }


}
