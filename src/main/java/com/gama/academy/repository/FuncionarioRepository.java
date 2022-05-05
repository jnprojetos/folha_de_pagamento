package com.gama.academy.repository;

import com.gama.academy.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByAtivo(Boolean ativo);
    Optional<Funcionario> findByCpfAndAtivo(String cpf, boolean ativo);
    Optional<Funcionario> findByIdAndAtivo(Long id, Boolean ativo);
}
