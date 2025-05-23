package com.lesvivienda.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EncuestaRequestDTO {
    
    @NotNull
    @NotEmpty
    private String titulo;

    @NotNull
    @NotEmpty
    private List<String> opciones;

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
}
