package com.lesvivienda.dto;

public class PropuestaDTO {

    private String nombre;
    private String propuesta;

    public PropuestaDTO() {
    }

    public PropuestaDTO(String nombre, String propuesta) {
        this.nombre = nombre;
        this.propuesta = propuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(String propuesta) {
        this.propuesta = propuesta;
    }
}
