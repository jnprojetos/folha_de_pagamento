package com.gama.academy.controller;

import com.gama.academy.dto.FuncionarioDTO;
import com.gama.academy.dto.FuncionarioDTOOutput;
import com.gama.academy.service.FuncionarioService;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("v1/funcionarios")
@Api(tags = "Funcionários")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Listar todos os funcionários")
    public ResponseEntity<Page<FuncionarioDTOOutput>> listar(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(service.listar(pageable));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ApiOperation(value = "Listar funcionário por id")
    public ResponseEntity<FuncionarioDTOOutput> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping(produces = "application/json")
    @ApiOperation(value = "Incluir um novo funcionário")
    public ResponseEntity<FuncionarioDTOOutput> adicionar(@Valid @RequestBody FuncionarioDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.novoFuncionario(dto));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    @ApiOperation(value = "Alterar um funcionário")
    public ResponseEntity<FuncionarioDTOOutput> alterar(@Valid @PathVariable Long id, @RequestBody FuncionarioDTO dto){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.alterar(id, dto));
    }

    @PostMapping(value = "/demitir/{id}", produces = "application/json")
    @ApiOperation(value = "Demitir um funcionário")
    public ResponseEntity<FuncionarioDTO> demitir(@PathVariable Long id){
        service.demitir(id);
        return ResponseEntity.noContent().build();
    }
}
