package com.lesvivienda.service;

import com.lesvivienda.model.Encuesta;
import com.lesvivienda.model.Suggestion;
import com.lesvivienda.model.User;
import com.lesvivienda.repository.EncuestaRepository;
import com.lesvivienda.repository.SuggestionRepository;
import com.lesvivienda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private SuggestionRepository suggestionRepository;

    @Autowired
    private EncuestaRepository encuestaRepository;

    @Autowired
    private UserRepository userRepository;

    // Obtener todos los mensajes de sugerencias
    public List<Suggestion> getAllSuggestions() {
        return suggestionRepository.findAll();
    }

    // Crear nueva encuesta
    public Encuesta createEncuesta(Encuesta encuesta, User adminUser) {
        encuesta.setCreatedBy(adminUser);
        return encuestaRepository.save(encuesta);
    }

    // Obtener todas las encuestas
    public List<Encuesta> getAllEncuestas() {
        return encuestaRepository.findAll();
    }

    // Verificar si usuario es admin
    public boolean isUserAdmin(User user) {
        return user != null && "ADMIN".equals(user.getRole());
    }
}