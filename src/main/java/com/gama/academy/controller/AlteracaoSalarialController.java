package com.gama.academy.controller;

import com.gama.academy.model.AlteracaoSalarial;
import com.gama.academy.service.AlteracaoSalarialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alteracoes-salariais")
@Api(tags = "Alteração Salarial")
public class AlteracaoSalarialController {

    @Autowired
    private AlteracaoSalarialService alteracaoSalarialService;

    @ApiOperation(value = "Incluri nova alteraçã salarial para um funcionário")
    @PostMapping(value = "/{id_funcionario}", produces = "application/json")
    public ResponseEntity<AlteracaoSalarial> novaAlteracao(@PathVariable Long id_funcionario, @RequestBody AlteracaoSalarial alteracaoSalarial){
        return ResponseEntity.status(HttpStatus.CREATED).body(alteracaoSalarialService.novaAlteracao(id_funcionario, alteracaoSalarial));
    }

    @ApiOperation(value = "Listar alterações salariais por funcionário")
    @GetMapping(value = "/{id_funcionario}", produces = "application/json")
    public ResponseEntity<List<AlteracaoSalarial>> listarPorFuncionario(@PathVariable Long id_funcionario){
        return ResponseEntity.status(HttpStatus.OK).body(alteracaoSalarialService.listarAlteracaoPorFuncionario(id_funcionario));
    }
}
