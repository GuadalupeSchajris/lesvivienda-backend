package com.lesvivienda.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesvivienda.model.Encuesta;
import com.lesvivienda.repository.EncuestaRepository;

@Service
public class EncuestaService {

    @Autowired
    private EncuestaRepository encuestaRepository;

    public Encuesta crearEncuesta(Encuesta encuesta) {
        if (encuesta.getOpciones() == null || encuesta.getOpciones().size() < 2 || encuesta.getOpciones().size() > 6) {
            throw new IllegalArgumentException("La encuesta debe tener entre 2 y 6 opciones.");
        }

        encuesta.setVotos(new HashMap<>());
        return encuestaRepository.save(encuesta);
    }

    public List<Encuesta> obtenerEncuestasActivas() {
        return encuestaRepository.findByFechaLimiteAfter(LocalDate.now());
    }

    public Encuesta votar(Long idEncuesta, int opcionIndex) {
        Encuesta encuesta = encuestaRepository.findById(idEncuesta)
            .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));

        if (opcionIndex < 0 || opcionIndex >= encuesta.getOpciones().size()) {
            throw new IllegalArgumentException("Opción inválida");
        }

        encuesta.getVotos().merge(opcionIndex, 1, Integer::sum);
        return encuestaRepository.save(encuesta);
    }
}
