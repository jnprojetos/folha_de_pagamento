package com.gama.academy.repository;


import com.gama.academy.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    Optional<Cargo> findByDescricaoAndCbo(String descricao, String cbo);

}
