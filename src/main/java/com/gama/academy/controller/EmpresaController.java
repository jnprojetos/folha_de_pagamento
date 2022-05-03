package com.gama.academy.controller;


import com.gama.academy.dto.EmpresaDTO;
import com.gama.academy.model.Empresa;
import com.gama.academy.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<Page<Empresa>> listar(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(empresaService.listarTodos(pageable));
    }

    @PostMapping
    public ResponseEntity<Empresa> adicionar(@Valid @RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.novaEmpresa(empresaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> alterar(@Valid @PathVariable Long id, @RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(empresaService.alterarEmpresa(id, empresaDTO));
    }
}
