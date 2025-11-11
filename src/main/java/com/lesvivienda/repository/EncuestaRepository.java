package com.lesvivienda.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lesvivienda.model.Encuesta;

@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta, UUID> {
    List<Encuesta> findByActiveTrue();
}