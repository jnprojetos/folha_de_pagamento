package com.gama.academy.repository;

import com.gama.academy.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepostiry extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findByNome(String nome);
}
