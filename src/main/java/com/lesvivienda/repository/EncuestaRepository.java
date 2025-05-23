package com.lesvivienda.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lesvivienda.model.Encuesta;

@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta, Long> {
    List<Encuesta> findByFechaLimiteAfter(LocalDate fecha);
}
