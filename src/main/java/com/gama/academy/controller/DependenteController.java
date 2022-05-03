package com.gama.academy.controller;

import com.gama.academy.dto.DependenteDTO;
import com.gama.academy.service.DependenteService;
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

@RestController
@RequestMapping("/v1/dependentes")
@Api(tags = "Dependentes")
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @GetMapping
    @ApiOperation(value = "Listar todos dependentes")
    public ResponseEntity<Page<DependenteDTO>> listar(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(dependenteService.listarTodos(pageable));
    }

    @ApiOperation(value = "Incluri novo dependente")
    @PostMapping
    public ResponseEntity<DependenteDTO> adicionar(@Valid @RequestBody DependenteDTO dependenteDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(dependenteService.novoDependente(dependenteDTO));
    }

    @ApiOperation(value = "Alterar dependente")
    @PutMapping("/{id}")
    public ResponseEntity<DependenteDTO> alterar(@Valid @PathVariable Long id, @RequestBody DependenteDTO dependenteDTO){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dependenteService.alterar(id, dependenteDTO));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar dependente")
    public ResponseEntity<DependenteDTO> excluir(@PathVariable Long id){
        dependenteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
