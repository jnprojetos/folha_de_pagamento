package com.gama.academy.service;

import com.gama.academy.model.AlteracaoSalarial;
import com.gama.academy.model.Funcionario;
import com.gama.academy.repository.AlteracaoSalarialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class AlteracaoSalarialService {

    @Autowired
    private AlteracaoSalarialRepository alteracaoSalarialRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    public AlteracaoSalarial novaAlteracao(Long id_funcionario, AlteracaoSalarial alteracaoSalarial){
        Funcionario funcionario = funcionarioService.buscarPorIdEAtivo(id_funcionario);
        funcionario.alterarSalario(alteracaoSalarial.getNovoSalario());
        alteracaoSalarial.setFuncionario(funcionario);
        alteracaoSalarial.setDataAlteracao(LocalDate.now());
        return alteracaoSalarialRepository.save(alteracaoSalarial);
    }

    public List<AlteracaoSalarial> listarAlteracaoPorFuncionario(Long id_funcionario){
        Funcionario funcionario = funcionarioService.buscarPorIdEAtivo(id_funcionario);
        return alteracaoSalarialRepository.findByFuncionario(funcionario);
    }
}
