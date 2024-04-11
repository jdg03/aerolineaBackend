package com.aerolinea.app.entities.dto;

import lombok.Data;

@Data
public class AvionDTO {

    private String marca;
    private int asientosPrimeraClase;
    private int asientosPremium;
    private int asientosBasico;

}
