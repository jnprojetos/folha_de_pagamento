package com.gama.academy.controller;

import com.gama.academy.dto.EnderecoDTO;
import com.gama.academy.service.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/enderecos")
@Api(tags = "Endereços")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    @ApiOperation(value = "Listar Todos Endereços")
    public ResponseEntity<List<EnderecoDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    @ApiOperation(value = "Inclur novo endereço")
    public ResponseEntity<EnderecoDTO> salvar(@Valid @RequestBody EnderecoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Alterar Endereço")
    public ResponseEntity<EnderecoDTO> alterar(@Valid @PathVariable Long id, @RequestBody EnderecoDTO dto){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.alterar(id, dto));
    }

    @ApiOperation(value = "Excluir um endereço")
    @DeleteMapping("/{id}")
    public ResponseEntity<EnderecoDTO> excluir(@Valid @PathVariable Long id) throws Exception {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
