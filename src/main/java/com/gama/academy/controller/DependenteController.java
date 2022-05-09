package com.gama.academy.controller;

import com.gama.academy.dto.DependenteDTO;
import com.gama.academy.dto.DependenteResumo;
import com.gama.academy.exception.EntidadeNaoEncontradaException;
import com.gama.academy.mapper.DependenteMapper;
import com.gama.academy.model.Funcionario;
import com.gama.academy.repository.FuncionarioRepository;
import com.gama.academy.service.DependenteService;
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
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/dependentes")
@Api(tags = "Dependentes")
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Listar todos dependentes", produces = "application/json")
    public ResponseEntity<Page<DependenteDTO>> listar(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(dependenteService.listarTodos(pageable));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ApiOperation(value = "Listar todos dependentes por funcionário", produces = "application/json")
    public ResponseEntity<List<DependenteResumo>> listarPorFuncionario(@PathVariable Long id){
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Funcionário não encontrado"));
        return ResponseEntity.ok(dependenteService.listarPorFuncionario(funcionario)
            .stream().map(dependente -> DependenteMapper.toDependenteResumo(dependente)).collect(Collectors.toList()));
    }

    @ApiOperation(value = "Incluri novo dependente")
    @PostMapping(produces = "application/json")
    public ResponseEntity<DependenteDTO> adicionar(@Valid @RequestBody DependenteDTO dependenteDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(dependenteService.novoDependente(dependenteDTO));
    }

    @ApiOperation(value = "Alterar dependente")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<DependenteDTO> alterar(@Valid @PathVariable Long id, @RequestBody DependenteDTO dependenteDTO){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dependenteService.alterar(id, dependenteDTO));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ApiOperation(value = "Deletar dependente")
    public ResponseEntity<DependenteDTO> excluir(@PathVariable Long id){
        dependenteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
