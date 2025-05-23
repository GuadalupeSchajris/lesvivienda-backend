package com.lesvivienda.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lesvivienda.dto.PropuestaDTO;
import com.lesvivienda.service.PropuestaService;

@RestController
@RequestMapping("/propuestas")
public class PropuestaController {

    private final PropuestaService propuestaService;

    // Constructor para inyección de dependencias
    public PropuestaController(PropuestaService propuestaService) {
        this.propuestaService = propuestaService;
    }

    @PostMapping
    public ResponseEntity<?> recibirPropuesta(@RequestBody PropuestaDTO propuestaDto) {
        String nombreFinal = (propuestaDto.getNombre() == null || propuestaDto.getNombre().trim().isEmpty())
                ? "Anónima"
                : propuestaDto.getNombre().trim();

        propuestaService.guardar(nombreFinal, propuestaDto.getPropuesta());

        return ResponseEntity.ok(Map.of("message", "Propuesta recibida correctamente"));
    }
}
