package com.gama.academy.service;

import com.gama.academy.dto.EmpresaDTO;
import com.gama.academy.mapper.EmpresaMapper;
import com.gama.academy.model.Empresa;
import com.gama.academy.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listarTodos(){
        return empresaRepository.findAll()
                .stream().map(empresa -> EmpresaMapper.toEmpresaDTO(empresa)).collect(Collectors.toList());
    }

    public Empresa novaEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = empresaRepository.save(EmpresaMapper.toEmpresa(empresaDTO));
        return EmpresaMapper.toEmpresaDTO(empresa);
    }

    public Empresa alterarEmpresa(Long id, EmpresaDTO empresaDTO){
        Empresa empresa = empresaRepository.findById(id).orElseThrow(()-> new RuntimeException("Empresa não encontrada"));
        empresaDTO.setId(empresa.getId());
        return EmpresaMapper.toEmpresaDTO(empresaRepository.save(EmpresaMapper.toEmpresa(empresaDTO)));
    }
}
