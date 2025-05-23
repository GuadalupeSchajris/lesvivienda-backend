package com.lesvivienda.dto;

import jakarta.validation.constraints.Min;

public class VotoRequestDTO {

    @Min(0)
    private int opcionIndex;

    public int getOpcionIndex() {
        return opcionIndex;
    }

    public void setOpcionIndex(int opcionIndex) {
        this.opcionIndex = opcionIndex;
    }
}
