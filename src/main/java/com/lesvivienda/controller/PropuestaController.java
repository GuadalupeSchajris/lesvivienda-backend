package com.lesvivienda.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propuestas")
@CrossOrigin(origins = "http://localhost:5173") // para permitir CORS
public class PropuestaController {

    // Aquí podrías inyectar un servicio para guardar la propuesta en BD
    // @Autowired private PropuestaService propuestaService;

    @PostMapping
    public ResponseEntity<?> recibirPropuesta(@RequestBody PropuestaDTO propuestaDto) {
        // Aquí puedes procesar la propuesta, guardarla, etc.
        System.out.println("Recibida propuesta de: " + propuestaDto.getNombre());
        System.out.println("Contenido: " + propuestaDto.getPropuesta());

        // propuestaService.guardar(propuestaDto);

        return ResponseEntity.ok(Map.of("message", "Propuesta recibida correctamente"));
    }

    public static class PropuestaDTO {
        private String nombre;
        private String propuesta;

        // Getters y setters
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getPropuesta() { return propuesta; }
        public void setPropuesta(String propuesta) { this.propuesta = propuesta; }
    }
}
