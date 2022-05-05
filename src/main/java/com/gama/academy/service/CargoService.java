package com.gama.academy.service;

import com.gama.academy.dto.CargoDTO;
import com.gama.academy.exception.EntidadeNaoEncontradaException;
import com.gama.academy.mapper.CargoMapper;
import com.gama.academy.model.Cargo;
import com.gama.academy.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public Page<CargoDTO> listarTodos(Pageable pageable){
        return cargoRepository.findAll(pageable)
                .map(CargoMapper::toCargoDTO);
    }

    public CargoDTO novoCargo(CargoDTO cargoDTO){
        Cargo cargo = cargoRepository.save(CargoMapper.toCargo(cargoDTO));
        return CargoMapper.toCargoDTO(cargo);
    }

    public CargoDTO alterar(Long id, CargoDTO cargoDTO) {
        Cargo cargo = findById(id);
        cargoDTO.setId(cargo.getId());
        return CargoMapper.toCargoDTO(cargoRepository.save(CargoMapper.toCargo(cargoDTO)));
    }

    public Cargo findById(Long id){
        Cargo cargo = cargoRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Cargo não encontrado"));
        return cargo;
    }

    public void excluir(Long id){
        Cargo cargo = findById(id);
        cargoRepository.delete(cargo);
    }
}
