package com.gama.academy.service;

import com.gama.academy.dto.FolhaDTO;
import com.gama.academy.dto.FuncionarioDTO;
import com.gama.academy.enums.EnumDeducaoDependente;
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
    private DependenteService dependenteService;

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
        List<Funcionario> funcionarios = funcionarioService.listarAtivos();

        funcionarios.forEach(funcionario -> gerarFolha(funcionario , competencia));
    }

    public FolhaDTO folhaPorFuncionario(Long id, String competencia) {
        if (folhaRepository.existsByCompetencia(competencia)) {
            throw new RegraNegocioException("Já existe uma folha de pagamento nessa competência");
        }
        Funcionario funcionario = funcionarioService.buscarPorIdEAtivo(id);
        return FolhaDTOMapper.toFolhaDTO(gerarFolha(funcionario, competencia));
    }

    public Page<FolhaDTO> consultarPorCompetenca(String competencia, Pageable pageable) {
        return folhaRepository.findByCompetencia(competencia, pageable).map(folha -> FolhaDTOMapper.toFolhaDTO(folha));
    }

    private Folha gerarFolha(Funcionario funcionario, String competencia) {
        BigDecimal valorDeducaoDependente = BigDecimal.ZERO;
        valorDeducaoDependente = calcularDeducacaoImpostoRenda(funcionario);
        BigDecimal valorInss = BigDecimal.ZERO;
        valorInss = valorInss.add(inss.calcularInss(funcionario.getSalarioAtual()));
        BigDecimal valoIrrf = BigDecimal.ZERO;
        valoIrrf = ir.calcularImpostoRenda(funcionario.getSalarioAtual().subtract(valorInss).subtract(valorDeducaoDependente));

        Folha folha = new Folha();
        folha.setCompetencia(competencia);
        folha.setFuncionario(funcionario);
        folha.setBaseFgts(funcionario.getSalarioAtual());
        folha.setBaseInss(funcionario.getSalarioAtual());
        folha.setBaseIrrf(funcionario.getSalarioAtual().subtract(valorInss).subtract(valorDeducaoDependente));
        folha.setFgts(fgts.calcularFgts(funcionario.getSalarioAtual()));
        folha.setInss(valorInss);
        folha.setIrrf(valoIrrf);
        folha.setTotalDesconto(valorInss.add(valoIrrf));
        folha.setSalarioLiquido(funcionario.getSalarioAtual().subtract(valoIrrf.add(valorInss)));
        return folhaRepository.save(folha);
    }

    private BigDecimal calcularTotalDescontos(BigDecimal salario) {
        return inss.calcularInss(salario).add(ir.calcularImpostoRenda(salario));
    }

    private BigDecimal calcularDeducacaoImpostoRenda(Funcionario funcionario){
        int numeroDependentes = 0;
        BigDecimal totalDeducaoDependente = BigDecimal.ZERO;
        List<Dependente> dependentes = dependenteService.listarPorFuncionario(funcionario);
        for(int i = 0; i < dependentes.size(); i++){
            if(dependentes.get(i).calculaIdade(dependentes.get(i).getDataNascimento()) <= 21){
                numeroDependentes += 1;
            }
        }
        if (numeroDependentes > 0){
            totalDeducaoDependente = EnumDeducaoDependente.DEDUCAO_POR_DEPENDENTE.getValor().multiply(BigDecimal.valueOf(numeroDependentes));
        }
        return totalDeducaoDependente;
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
