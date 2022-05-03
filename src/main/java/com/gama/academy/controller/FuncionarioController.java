package com.gama.academy.controller;

import com.gama.academy.dto.FuncionarioDTO;
import com.gama.academy.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<FuncionarioDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<FuncionarioDTO> salvar(@Valid @RequestBody FuncionarioDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> alterar(@Valid @PathVariable Long id, @RequestBody FuncionarioDTO dto){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.alterar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> excluir(@Valid @PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.excluir(id));
    }

    @GetMapping("/dataHoje")
    public ResponseEntity<String>getData(){
        return ResponseEntity.status(HttpStatus.OK).body(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString());
    }
}
