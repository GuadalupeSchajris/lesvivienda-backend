package com.lesvivienda.controller;

import com.lesvivienda.model.Encuesta;
import com.lesvivienda.model.Suggestion;
import com.lesvivienda.model.User;
import com.lesvivienda.service.AdminService;
import com.lesvivienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    // Obtener todos los mensajes de sugerencias
    @GetMapping("/suggestions")
    public ResponseEntity<List<Suggestion>> getSuggestions(Authentication authentication) {
        try {
            User user = userService.getUserFromAuthentication(authentication);
            
            if (!adminService.isUserAdmin(user)) {
                return ResponseEntity.status(403).build();
            }

            List<Suggestion> suggestions = adminService.getAllSuggestions();
            return ResponseEntity.ok(suggestions);
        } catch (Exception e) {
            return ResponseEntity.status(403).build();
        }
    }

    // Crear nueva encuesta
    @PostMapping("/encuestas")
    public ResponseEntity<Encuesta> createEncuesta(@RequestBody Encuesta encuesta, Authentication authentication) {
        try {
            User user = userService.getUserFromAuthentication(authentication);
            
            if (!adminService.isUserAdmin(user)) {
                return ResponseEntity.status(403).build();
            }

            Encuesta createdEncuesta = adminService.createEncuesta(encuesta, user);
            return ResponseEntity.ok(createdEncuesta);
        } catch (Exception e) {
            return ResponseEntity.status(403).build();
        }
    }

    // Obtener todas las encuestas
    @GetMapping("/encuestas")
    public ResponseEntity<List<Encuesta>> getEncuestas(Authentication authentication) {
        try {
            User user = userService.getUserFromAuthentication(authentication);
            
            if (!adminService.isUserAdmin(user)) {
                return ResponseEntity.status(403).build();
            }

            List<Encuesta> encuestas = adminService.getAllEncuestas();
            return ResponseEntity.ok(encuestas);
        } catch (Exception e) {
            return ResponseEntity.status(403).build();
        }
    }
}