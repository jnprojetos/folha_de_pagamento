package com.gama.academy.service;

import com.gama.academy.dto.FuncionarioDTO;
import com.gama.academy.dto.FuncionarioDTOOutput;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public FuncionarioDTOOutput novoFuncionario(FuncionarioDTO dto) {
        Cargo cargo = cargoService.findById(dto.getCargo().getId());
        Empresa empresa = empresaService.findById(dto.getEmpresa().getId());
        Endereco endereco = enderecoService.findById(dto.getEndereco().getId());
        dto.setCargo(CargoMapper.toCargoDTO(cargo));
        dto.setEmpresa(EmpresaMapper.toEmpresaDTO(empresa));
        dto.setEndereco(EnderecoMapper.toEnderecoDTO(endereco));
        Funcionario funcionario = FuncionarioMapper.toFuncionario(dto);
        funcionario.admitir();
        return FuncionarioMapper.toFuncionarioOutput(repository.save(funcionario));
    }

    public FuncionarioDTOOutput alterar(Long id, FuncionarioDTO dto){
        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Funcionário não encontrado."));
        dto.setId(funcionario.getId());
        return FuncionarioMapper.toFuncionarioOutput(repository.save(FuncionarioMapper.toFuncionario(dto)));
    }

    public void excluir(Long id){
        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Funcionário não encontrado."));
        repository.delete(funcionario);
    }

    public Page<FuncionarioDTOOutput> listar(Pageable pageable){
        return repository.findAll(pageable).map(funcionario -> FuncionarioMapper.toFuncionarioOutput(funcionario));
    }

    public List<Funcionario> listarAtivos(){
        return repository.findByAtivo(true);
    }

    public Funcionario buscarPorIdEAtivo(Long id){
        return repository.findByIdAndAtivo(id, true).orElseThrow(()-> new EntidadeNaoEncontradaException("Funcionário não encontrado"));
    }

    public FuncionarioDTOOutput buscarPorId(Long id){
        return FuncionarioMapper.toFuncionarioOutput(repository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Funcionário não encontrado")));
    }

    public void demitir(Long id){
        Funcionario funcionario = buscarPorIdEAtivo(id);
        funcionario.demitir();
        repository.save(funcionario);
    }

}
