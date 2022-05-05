package com.gama.academy.repository;

import com.gama.academy.model.Dependente;
import com.gama.academy.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {

    List<Dependente> findByFuncionario(Funcionario funcionario);
    Optional<Dependente> findByCpf(String cpf);
}
