package com.gama.academy.controller;


import com.gama.academy.dto.CargoDTO;
import com.gama.academy.service.CargoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/cargos")
@Api(tags = "Cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    @ApiOperation(value = "Listar todos cargos")
    public ResponseEntity<Page<CargoDTO>> listar(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(cargoService.listarTodos(pageable));
    }

    @PostMapping(produces = "application/json")
    @ApiOperation(value = "Criar um cargo")
    public ResponseEntity<CargoDTO> adicionar(@Valid @RequestBody CargoDTO cargoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.novoCargo(cargoDTO));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    @ApiOperation(value = "Alterar um cargo")
    public ResponseEntity<CargoDTO> alterar(@Valid @PathVariable Long id, @RequestBody CargoDTO cargoDTO){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cargoService.alterar(id, cargoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CargoDTO> excluir(@PathVariable Long id){
        cargoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
