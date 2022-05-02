package com.gama.academy.controller;

import com.gama.academy.dto.FolhaDTO;
import com.gama.academy.model.Folha;
import com.gama.academy.service.FolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/folhas")
public class FolhaController {

    @Autowired
    FolhaService folhaService;

    @PostMapping("/{id}/{competencia}")
    public ResponseEntity<FolhaDTO> gerarFolhaPorFuncionario(@PathVariable Long id, @PathVariable String competencia){
        return ResponseEntity.status(HttpStatus.CREATED).body(folhaService.folhaPorFuncionario(id, competencia));
    }

    @PostMapping("/geral/{competencia}")
    public ResponseEntity<Folha> gerarFolhaGeral(@PathVariable String competencia){
        folhaService.folhaGeral(competencia);
       return ResponseEntity.ok().build();
    }

    @GetMapping("/competencia/{competencia}")
    public ResponseEntity<Page<FolhaDTO>> listarFolhaPorCompetencia(@PathVariable String competencia, @PageableDefault Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(folhaService.consultarPorCompetenca(competencia, pageable));
    }

    @GetMapping("/competencia/{competencia}/{id}")
    public ResponseEntity<Folha> buscarPorCompetenciaFuncionario(@PathVariable String competencia, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(folhaService.buscarPorCompetenciaFuncionario(competencia, id));
    }

    @DeleteMapping("/{competencia}/{id}")
    public ResponseEntity<Folha> excluirFolhaPorFuncionario(@PathVariable String competencia, @PathVariable Long id){
        folhaService.excluirFolhaPorFuncionario(competencia, id);
        return ResponseEntity.ok().build();
    }
}
