package com.lesvivienda.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lesvivienda.dto.EncuestaRequestDTO;
import com.lesvivienda.dto.EncuestaResponseDTO;
import com.lesvivienda.dto.VotoRequestDTO;
import com.lesvivienda.model.Encuesta;
import com.lesvivienda.service.EncuestaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/encuestas")
@CrossOrigin
public class EncuestaController {

    @Autowired
    private EncuestaService encuestaService;

    @PostMapping
    public ResponseEntity<EncuestaResponseDTO> crearEncuesta(@Valid @RequestBody EncuestaRequestDTO dto) {
        Encuesta encuesta = new Encuesta();
        encuesta.setTitulo(dto.getTitulo());
        encuesta.setOpciones(dto.getOpciones());

        Encuesta creada = encuestaService.crearEncuesta(encuesta);

        return ResponseEntity.ok(mapToResponseDTO(creada));
    }

    @GetMapping("/activas")
    public ResponseEntity<List<EncuestaResponseDTO>> getEncuestasActivas() {
        List<Encuesta> encuestas = encuestaService.obtenerEncuestasActivas();
        List<EncuestaResponseDTO> dtos = encuestas.stream()
            .map(this::mapToResponseDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/{id}/votar")
    public ResponseEntity<EncuestaResponseDTO> votar(@PathVariable Long id, @Valid @RequestBody VotoRequestDTO votoRequest) {
        Encuesta encuesta = encuestaService.votar(id, votoRequest.getOpcionIndex());
        return ResponseEntity.ok(mapToResponseDTO(encuesta));
    }

    private EncuestaResponseDTO mapToResponseDTO(Encuesta encuesta) {
        EncuestaResponseDTO dto = new EncuestaResponseDTO();
        dto.setId(encuesta.getId());
        dto.setTitulo(encuesta.getTitulo());
        dto.setOpciones(encuesta.getOpciones());

        List<Integer> votosList = IntStream.range(0, encuesta.getOpciones().size())
            .mapToObj(i -> encuesta.getVotos().getOrDefault(i, 0))
            .collect(Collectors.toList());

        dto.setVotos(votosList);
        return dto;
    }

}

