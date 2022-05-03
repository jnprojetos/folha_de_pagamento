package com.gama.academy.controller;

import com.gama.academy.dto.LoginFormDTO;
import com.gama.academy.dto.TokenDTO;
import com.gama.academy.mapper.LoginFormMapper;
import com.gama.academy.security.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Api(tags = "Autenticação")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    @ApiOperation(value = "Gerar token")
    @PostMapping(produces = "application/json")
    public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginFormDTO form){
        UsernamePasswordAuthenticationToken dadosLogin = LoginFormMapper.toLoginForm(form).converter();

        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        }catch (AuthenticationException ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
