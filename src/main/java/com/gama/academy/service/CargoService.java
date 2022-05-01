package com.gama.academy.service;

import com.gama.academy.dto.CargoDTO;
import com.gama.academy.mapper.CargoMapper;
import com.gama.academy.model.Cargo;
import com.gama.academy.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public List<CargoDTO> listarTodos(){
        return cargoRepository.findAll()
                .stream().map(CargoMapper::toCargoDTO).collect(Collectors.toList());
    }

    public CargoDTO novoCargo(CargoDTO cargoDTO){
        Cargo cargo = cargoRepository.save(CargoMapper.toCargo(cargoDTO));
        return CargoMapper.toCargoDTO(cargo);
    }

    public CargoDTO alterar(Long id, CargoDTO cargoDTO) {
        Cargo cargo = cargoRepository.findById(id).orElseThrow(()-> new RuntimeException("Cargo não encontrado"));
        cargoDTO.setId(cargo.getId());
        return CargoMapper.toCargoDTO(cargoRepository.save(CargoMapper.toCargo(cargoDTO)));
    }
}
