package com.gama.academy.controller;


import com.gama.academy.dto.EmpresaDTO;
import com.gama.academy.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> listar(){
      return ResponseEntity.ok(empresaService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> adicionar(@Valid @RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.novaEmpresa(empresaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> alterar(@Valid @PathVariable Long id, @RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(empresaService.alterarEmpresa(id, empresaDTO));
    }
}
