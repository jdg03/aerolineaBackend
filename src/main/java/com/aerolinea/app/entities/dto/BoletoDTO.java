package com.aerolinea.app.entities.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BoletoDTO {

    private int idVuelo;
    private int idAsiento;
    private LocalDate fecha;
    private double precionTotal;
    
}
