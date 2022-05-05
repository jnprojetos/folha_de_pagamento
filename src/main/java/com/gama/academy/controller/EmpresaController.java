package com.gama.academy.controller;


import com.gama.academy.dto.EmpresaDTO;
import com.gama.academy.mapper.EmpresaMapper;
import com.gama.academy.service.EmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/empresas")
@Api(tags = "Empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @ApiOperation(value = "Listar todas as empresas")
    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> listar(){
      return ResponseEntity.ok(empresaService.listarTodos());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listar empresa por id")
    public ResponseEntity<EmpresaDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(EmpresaMapper.toEmpresaDTO(empresaService.findById(id)));
    }

    @PostMapping
    @ApiOperation(value = "Incluir uma nova empresa")
    public ResponseEntity<EmpresaDTO> adicionar(@Valid @RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.novaEmpresa(empresaDTO));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Alterar uma empresa")
    public ResponseEntity<EmpresaDTO> alterar(@Valid @PathVariable Long id, @RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(empresaService.alterarEmpresa(id, empresaDTO));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Excluir uma empresa")
    public ResponseEntity<EmpresaDTO> excluir(@PathVariable Long id){
        empresaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
