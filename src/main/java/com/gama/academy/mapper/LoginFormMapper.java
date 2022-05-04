package com.gama.academy.mapper;

import com.gama.academy.dto.LoginFormDTO;
import com.gama.academy.model.LoginForm;

public class LoginFormMapper {

    public static LoginForm toLoginForm(LoginFormDTO dto){
        return new LoginForm(dto.getEmail(), dto.getSenha());
    }
}
