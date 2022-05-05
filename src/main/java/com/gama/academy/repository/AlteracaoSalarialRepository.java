package com.gama.academy.repository;

import com.gama.academy.model.AlteracaoSalarial;
import com.gama.academy.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlteracaoSalarialRepository extends JpaRepository<AlteracaoSalarial, Long> {

    List<AlteracaoSalarial> findByFuncionario(Funcionario funcionario);
}
