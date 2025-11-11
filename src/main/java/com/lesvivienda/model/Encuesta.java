package com.lesvivienda.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Encuesta {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID id;

    private String titulo;  
    private String descripcion; // 👈 NUEVO campo

    @ElementCollection
    private List<String> opciones;

    private LocalDate fechaLimite;
    private LocalDateTime createdAt; // 👈 NUEVO campo
    private boolean active; // 👈 NUEVO campo

    // 👈 NUEVA relación con el usuario que creó la encuesta
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ElementCollection
    private Map<Integer, Integer> votos = new HashMap<>();

    // 👈 NUEVOS constructores
    public Encuesta() {
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    public Encuesta(String titulo, String descripcion, List<String> opciones, LocalDate fechaLimite, User createdBy) {
        this();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.opciones = opciones;
        this.fechaLimite = fechaLimite;
        this.createdBy = createdBy;
    }

    // Getters y Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // 👈 NUEVOS getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Map<Integer, Integer> getVotos() {
        return votos;
    }

    public void setVotos(Map<Integer, Integer> votos) {
        this.votos = votos;
    }
}