package com.gama.academy.repository;

import com.gama.academy.model.Folha;
import com.gama.academy.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FolhaRepository extends JpaRepository<Folha, Long> {
    public Page<Folha> findByCompetencia(String competencia, Pageable pageable);
    public Boolean existsByCompetencia(String competencia);
    public Optional<Folha> findByCompetenciaAndFuncionario(String competencia, Funcionario funcionario);
}
