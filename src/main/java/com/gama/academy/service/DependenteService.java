package com.gama.academy.service;

import com.gama.academy.dto.DependenteDTO;
import com.gama.academy.exception.EntidadeNaoEncontradaException;
import com.gama.academy.exception.RegraNegocioException;
import com.gama.academy.mapper.DependenteMapper;
import com.gama.academy.mapper.FuncionarioMapper;
import com.gama.academy.model.Dependente;
import com.gama.academy.model.Funcionario;
import com.gama.academy.repository.DependenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
   FuncionarioService funcionarioService;

    public Page<DependenteDTO> listarTodos(Pageable pageable){
        return dependenteRepository.findAll(pageable)
                .map(dependente -> DependenteMapper.toDependenteDTO(dependente));
    }

    public DependenteDTO novoDependente(DependenteDTO dependenteDTO){
        boolean dependenteJaCadastrado = dependenteRepository.findByCpf(dependenteDTO.getCpf())
                .stream().anyMatch(dependenteExistente -> !dependenteExistente.equals(dependenteDTO));
        if (dependenteJaCadastrado){
            throw new RegraNegocioException("Já existe um dependente cadastrado com esse cpf");
        }
        Funcionario funcionario = funcionarioService.buscarPorIdEAtivo(dependenteDTO.getFuncionario().getId());
        dependenteDTO.setFuncionario(FuncionarioMapper.toFuncionarioDTO(funcionario));
        Dependente dependente = dependenteRepository.save(DependenteMapper.toDependente(dependenteDTO));
        return DependenteMapper.toDependenteDTO(dependente);
    }

    public DependenteDTO alterar(Long id, DependenteDTO dependenteDTO){
        Dependente dependente = dependenteRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Dependente não encontrado"));
        dependenteDTO.setId(dependente.getId());
        return DependenteMapper.toDependenteDTO(dependenteRepository.save(DependenteMapper.toDependente(dependenteDTO)));
    }

    public void excluir(Long id){
        Dependente dependente = dependenteRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Dependente não encontrado"));
        dependenteRepository.delete(dependente);
    }

    public List<Dependente> listarPorFuncionario(Funcionario funcionario){
        return dependenteRepository.findByFuncionario(funcionario);
    }
}
