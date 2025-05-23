package com.lesvivienda.dto;

import java.util.List;

public class EncuestaResponseDTO {

    private Long id;
    private String titulo;
    private List<String> opciones;
    private List<Integer> votos;

    public EncuestaResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public List<Integer> getVotos() {
        return votos;
    }

    public void setVotos(List<Integer> votos) {
        this.votos = votos;
    }
}
