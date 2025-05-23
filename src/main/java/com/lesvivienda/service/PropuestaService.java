package com.lesvivienda.service;

import org.springframework.stereotype.Service;

import com.lesvivienda.model.Propuesta;
import com.lesvivienda.repository.PropuestaRepository;

@Service
public class PropuestaService {

    private final PropuestaRepository propuestaRepository;

    public PropuestaService(PropuestaRepository propuestaRepository) {
        this.propuestaRepository = propuestaRepository;
    }

    public void guardar(String nombre, String propuestaTexto) {
        Propuesta propuesta = new Propuesta();
        propuesta.setNombre(nombre);
        propuesta.setPropuesta(propuestaTexto);
        propuestaRepository.save(propuesta);
    }
}
