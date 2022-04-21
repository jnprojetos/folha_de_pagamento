package com.gama.academy.controller;

import com.gama.academy.dto.DependenteDTO;
import com.gama.academy.service.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @GetMapping
    public ResponseEntity<List<DependenteDTO>> listar(){
        return ResponseEntity.ok(dependenteService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<DependenteDTO> adicionar(@Valid @RequestBody DependenteDTO dependenteDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(dependenteService.novoDependente(dependenteDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DependenteDTO> alterar(@Valid @PathVariable Long id, @RequestBody DependenteDTO dependenteDTO){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dependenteService.alterar(id, dependenteDTO));
    }
}
