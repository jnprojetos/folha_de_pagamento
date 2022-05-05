package com.gama.academy.service;

import com.gama.academy.exception.EntidadeNaoEncontradaException;
import com.gama.academy.model.Perfil;
import com.gama.academy.repository.PerfilRepostiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PerfilService {

    @Autowired
    private PerfilRepostiry perfilRepostiry;

    public Perfil buscaPorNome(String nome){
        return perfilRepostiry.findByNome(nome).orElseThrow(()-> new EntidadeNaoEncontradaException("Perfil não cadastrado"));
    }
    public Perfil buscaPorId(Long id){
        return perfilRepostiry.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Perfil não encontrado"));
    }
}
