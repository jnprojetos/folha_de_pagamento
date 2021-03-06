package com.gama.academy.controller;

import com.gama.academy.dto.FolhaDTO;
import com.gama.academy.mapper.FolhaDTOMapper;
import com.gama.academy.model.Folha;
import com.gama.academy.service.FolhaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/fechamentos")
@Api(tags = "Folha")
public class FolhaController {

    @Autowired
    FolhaService folhaService;

    @ApiOperation(value = "Gerar folha de pagamento por funcionário")
    @PostMapping(value = "funcionario/{id}/competencia/{competencia}",produces = "application/json")
    public ResponseEntity<FolhaDTO> gerarFolhaPorFuncionario(@PathVariable Long id, @PathVariable String competencia){
        return ResponseEntity.status(HttpStatus.CREATED).body(folhaService.folhaPorFuncionario(id, competencia));
    }

    @ApiOperation(value = "Gerar folha de pagamento geral")
    @PostMapping(value = "/competencia/{competencia}", produces = "application/json")
    public ResponseEntity<Folha> gerarFolhaGeral(@PathVariable String competencia){
        folhaService.folhaGeral(competencia);
       return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Consultar folha de pagamento por competência")
    @GetMapping(value = "/competencia/{competencia}", produces = "application/json")
    public ResponseEntity<Page<FolhaDTO>> listarFolhaPorCompetencia(@PathVariable String competencia, @PageableDefault Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(folhaService.consultarPorCompetenca(competencia, pageable));
    }

    @ApiOperation(value = "Consultar folha de pagamento por funcionário e competência")
    @GetMapping(value = "/funcionario/{id}/competencia/{competencia}", produces = "application/json")
    public ResponseEntity<FolhaDTO> buscarPorCompetenciaFuncionario(@PathVariable String competencia, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(FolhaDTOMapper.toFolhaDTO(folhaService.buscarPorCompetenciaFuncionario(competencia, id)));
    }

    @ApiOperation(value = "Excluir folha de pagamento por competência")
    @DeleteMapping(value = "competencia/{competencia}", produces = "application/json")
    public ResponseEntity<Folha> excluirFolhaPorCompetencia(@PathVariable String competencia, Pageable pageable){
        folhaService.excluirFolhaPorCompetencia(competencia, pageable);
        return ResponseEntity.ok().build();
    }
}
