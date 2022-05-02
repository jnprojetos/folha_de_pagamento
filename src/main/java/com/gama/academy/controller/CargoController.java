package com.gama.academy.controller;


import com.gama.academy.dto.CargoDTO;
import com.gama.academy.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<CargoDTO>> listar(){return ResponseEntity.ok(cargoService.listarTodos());}

    @PostMapping
    public ResponseEntity<CargoDTO> adicionar(@Valid @RequestBody CargoDTO cargoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.novoCargo(cargoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoDTO> alterar(@Valid @PathVariable Long id, @RequestBody CargoDTO cargoDTO){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cargoService.alterar(id, cargoDTO));
    }

}
