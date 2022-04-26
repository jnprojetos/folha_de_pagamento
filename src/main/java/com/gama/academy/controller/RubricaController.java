package com.gama.academy.controller;

import com.gama.academy.dto.RubricaDTO;
import com.gama.academy.service.RubricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rubricas")
public class RubricaController {

    @Autowired
    private RubricaService rubricaService;

    @PostMapping
    public ResponseEntity<RubricaDTO> adicionar(@RequestBody RubricaDTO rubricaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(rubricaService.novaRubrica(rubricaDTO));
    }

    @GetMapping
    public ResponseEntity<List<RubricaDTO>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(rubricaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RubricaDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(rubricaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RubricaDTO> alterar(@PathVariable Long id, @RequestBody RubricaDTO rubricaDTO){
        return ResponseEntity.status(HttpStatus.OK).body(rubricaService.alterar(id, rubricaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RubricaDTO> excluir(@PathVariable Long id){
        rubricaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
