package com.gama.academy.mapper;

import com.gama.academy.dto.UsuarioDTO;
import com.gama.academy.model.Usuario;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioDTO dto){
        return new Usuario(null, dto.getNome(), dto.getEmail(), dto.getSenha(), dto.getPerfil());
    }

}
