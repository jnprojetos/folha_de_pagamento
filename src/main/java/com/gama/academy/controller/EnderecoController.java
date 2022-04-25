package com.gama.academy.controller;

import com.gama.academy.dto.EnderecoDTO;
import com.gama.academy.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> salvar(@Valid @RequestBody EnderecoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> alterar(@Valid @PathVariable Long id, @RequestBody EnderecoDTO dto){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.alterar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnderecoDTO> excluir(@Valid @PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.excluir(id));
    }
}
