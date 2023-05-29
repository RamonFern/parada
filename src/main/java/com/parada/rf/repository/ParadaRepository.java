package com.parada.rf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parada.rf.domain.model.Parada;

public interface ParadaRepository extends JpaRepository<Parada, String>{

	Optional<Parada> findById(Long id);

}
