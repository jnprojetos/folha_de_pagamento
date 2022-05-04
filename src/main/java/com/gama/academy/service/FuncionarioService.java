package com.gama.academy.service;

import com.gama.academy.dto.FuncionarioDTO;
import com.gama.academy.exception.EntidadeNaoEncontradaException;
import com.gama.academy.mapper.CargoMapper;
import com.gama.academy.mapper.EmpresaMapper;
import com.gama.academy.mapper.EnderecoMapper;
import com.gama.academy.mapper.FuncionarioMapper;
import com.gama.academy.model.Cargo;
import com.gama.academy.model.Empresa;
import com.gama.academy.model.Endereco;
import com.gama.academy.model.Funcionario;
import com.gama.academy.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    @Autowired
    CargoService cargoService;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    EnderecoService enderecoService;

    public FuncionarioDTO salvar(FuncionarioDTO dto) {
        Funcionario funcionario = prepararCadastroFuncionario(dto);
        return FuncionarioMapper.toFuncionarioDTO(repository.save(funcionario));
    }

    public FuncionarioDTO alterar(Long id, FuncionarioDTO dto){
        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Funcionário não encontrado."));
        dto.setId(funcionario.getId());
        return salvar(dto);
    }

    public FuncionarioDTO excluir(Long id){
        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Funcionário não encontrado."));
        repository.delete(funcionario);
        return FuncionarioMapper.toFuncionarioDTO(funcionario);
    }

    public List<FuncionarioDTO> listar(){
        return FuncionarioMapper.toListFuncionarioDTO(repository.findAll());
    }

    public List<Funcionario> listarAtivos(){
        return repository.findByAtivo(true);
    }

    public Funcionario buscarPorIdEAtivo(Long id){
        return repository.findByIdAndAtivo(id, true).orElseThrow(()-> new EntidadeNaoEncontradaException("Funcionário não encontrado"));
    }

    public FuncionarioDTO buscarPorId(Long id){
        return FuncionarioMapper.toFuncionarioDTO(repository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Funcionário não encontrado")));
    }

    private Funcionario prepararCadastroFuncionario(FuncionarioDTO dto){
        Funcionario funcionario = FuncionarioMapper.toFuncionario(dto);
        Cargo cargo = null;
        Empresa empresa = null;
        Endereco endereco = null;
        if (dto.getCargo() != null && dto.getCargo().getId() != null) {
            cargo = cargoService.findById(dto.getCargo().getId());
        }
        if (dto.getEmpresa() != null && dto.getEmpresa().getId() != null) {
            empresa = empresaService.findById(dto.getEmpresa().getId());
        }
        if (dto.getEndereco() != null && dto.getEndereco().getId() != null) {
            endereco = enderecoService.findById(dto.getEndereco().getId());
        }
        if (cargo != null) {
            funcionario.setCargo(cargo);
        } else {
            funcionario.setCargo(CargoMapper.toCargo(cargoService.novoCargo(dto.getCargo())));
        }
        if (empresa != null) {
            funcionario.setEmpresa(empresa);
        } else {
            funcionario.setEmpresa(EmpresaMapper.toEmpresa(empresaService.novaEmpresa(dto.getEmpresa())));
        }
        if (empresa != null) {
            funcionario.setEmpresa(empresa);
        } else {
            funcionario.setEmpresa(EmpresaMapper.toEmpresa(empresaService.novaEmpresa(dto.getEmpresa())));
        }
        if (endereco != null) {
            funcionario.setEmpresa(empresa);
        } else {
            funcionario.setEndereco(EnderecoMapper.toEndereco(enderecoService.salvar(dto.getEndereco())));
        }
        return funcionario;
    }
}
