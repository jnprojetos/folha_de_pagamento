package com.gama.academy.service;

import com.gama.academy.dto.EmpresaDTO;
import com.gama.academy.exception.EntidadeNaoEncontradaException;
import com.gama.academy.mapper.EmpresaMapper;
import com.gama.academy.mapper.EnderecoMapper;
import com.gama.academy.model.Empresa;
import com.gama.academy.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EnderecoService enderecoService;

    public List<EmpresaDTO> listarTodos(){
        return empresaRepository.findAll()
                .stream().map(empresa -> EmpresaMapper.toEmpresaDTO(empresa)).collect(Collectors.toList());
    }

    public EmpresaDTO novaEmpresa(EmpresaDTO empresaDTO){
        if (empresaDTO.getEndereco() != null) {
            if (empresaDTO.getEndereco().getId() != null) {
                empresaDTO.setEndereco(EnderecoMapper.toEnderecoDTO(enderecoService.findById(empresaDTO.getEndereco().getId())));
            } else {
                empresaDTO.setEndereco((enderecoService.salvar(empresaDTO.getEndereco())));
            }
        }
        Empresa empresa = EmpresaMapper.toEmpresa(empresaDTO);
        return EmpresaMapper.toEmpresaDTO(empresaRepository.save(empresa));
    }

    public EmpresaDTO alterarEmpresa(Long id, EmpresaDTO empresaDTO){
        Empresa empresa = empresaRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Empresa não encontrada"));
        empresaDTO.setId(empresa.getId());
        return EmpresaMapper.toEmpresaDTO(empresaRepository.save(EmpresaMapper.toEmpresa(empresaDTO)));
    }

    public Empresa findById(Long id){
        Empresa empresa = empresaRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Empresa não encontrada"));
        return empresa;
    }

    public void excluir(Long id){
        Empresa empresa = findById(id);
        empresaRepository.delete(empresa);
    }
}
