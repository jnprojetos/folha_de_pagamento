package com.gama.academy.repository;

import com.gama.academy.model.Rubrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubricaRepository extends JpaRepository<Rubrica, Long> {
}
