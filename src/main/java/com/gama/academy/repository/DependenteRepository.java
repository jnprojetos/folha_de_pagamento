package com.gama.academy.repository;

import com.gama.academy.model.Dependente;
import com.gama.academy.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {

    List<Dependente> findByFuncionario(Funcionario funcionario);
}
