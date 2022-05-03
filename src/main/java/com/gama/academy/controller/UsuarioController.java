package com.gama.academy.controller;


import com.gama.academy.dto.UsuarioDTO;
import com.gama.academy.mapper.UsuarioMapper;
import com.gama.academy.model.Usuario;
import com.gama.academy.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Usuários")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ApiOperation(value = "Cria um novo usuário")
    @PostMapping(produces = "application/json")
    public Usuario novoUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        return usuarioService.novoUsuario(UsuarioMapper.toUsuario(usuarioDTO));
    }

}
