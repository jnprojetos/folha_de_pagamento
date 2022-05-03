package com.gama.academy.service;

import com.gama.academy.dto.FolhaDTO;
import com.gama.academy.dto.FuncionarioDTO;
import com.gama.academy.exception.EntidadeNaoEncontradaException;
import com.gama.academy.exception.RegraNegocioException;
import com.gama.academy.mapper.FolhaDTOMapper;
import com.gama.academy.mapper.FuncionarioMapper;
import com.gama.academy.model.*;
import com.gama.academy.repository.FolhaRepository;
import com.gama.academy.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FolhaService {

    @Autowired
    private FolhaRepository folhaRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private Inss inss;

    @Autowired
    private Fgts fgts;

    @Autowired
    private ImpostoDeRenda ir;


    public void folhaGeral(String competencia) {
        if (folhaRepository.existsByCompetencia(competencia)) {
            throw new RegraNegocioException("Já existe uma folha de pagamento nessa competência");
        }
        List<FuncionarioDTO> funcionarios = funcionarioService.listar();
        for (int i = 0; i < funcionarios.size(); i++) {
            gerarFolha(FuncionarioMapper.toFuncionario(funcionarios.get(i)), competencia);
        }
    }

    public FolhaDTO folhaPorFuncionario(Long id, String competencia) {
        if (folhaRepository.existsByCompetencia(competencia)) {
            throw new RegraNegocioException("Já existe uma folha de pagamento nessa competência");
        }
        Funcionario funcionario = FuncionarioMapper.toFuncionario(funcionarioService.buscarPorId(id));
        return FolhaDTOMapper.toFolhaDTO(gerarFolha(funcionario, competencia));
    }

    public Page<FolhaDTO> consultarPorCompetenca(String competencia, Pageable pageable) {
        return folhaRepository.findByCompetencia(competencia, pageable).map(folha -> FolhaDTOMapper.toFolhaDTO(folha));
    }

    private Folha gerarFolha(Funcionario funcionario, String competencia) {
        Folha folha = new Folha();
        folha.setCompetencia(competencia);
        folha.setFuncionario(funcionario);
        folha.setBaseFgts(funcionario.getSalarioAtual());
        folha.setBaseInss(funcionario.getSalarioAtual());
        folha.setBaseIrrf(funcionario.getSalarioAtual().subtract(inss.calcularInss(funcionario.getSalarioAtual())));
        folha.setFgts(fgts.calcularFgts(funcionario.getSalarioAtual()));
        folha.setInss(inss.calcularInss(funcionario.getSalarioAtual()));
        folha.setIrrf(ir.calcularImpostoRenda(funcionario.getSalarioAtual().subtract(inss.calcularInss(funcionario.getSalarioAtual()))));
        folha.setTotalDesconto(calcularTotalDescontos(funcionario.getSalarioAtual()));
        folha.setSalarioLiquido(funcionario.getSalarioAtual().subtract(calcularTotalDescontos(funcionario.getSalarioAtual())));
        return folhaRepository.save(folha);
    }

    private BigDecimal calcularTotalDescontos(BigDecimal salario) {
        return inss.calcularInss(salario).add(ir.calcularImpostoRenda(salario));
    }

    public Folha buscarPorCompetenciaFuncionario(String competencia, Long id){
        Funcionario funcionario = FuncionarioMapper.toFuncionario(funcionarioService.buscarPorId(id));
        return folhaRepository.findByCompetenciaAndFuncionario(competencia, funcionario).get();
    }

    public void excluirFolhaPorCompetencia(String competencia, Pageable pageable){
        Page<Folha> folhas = folhaRepository.findByCompetencia(competencia, pageable);

       folhaRepository.deleteAll(folhas);
    }
}
