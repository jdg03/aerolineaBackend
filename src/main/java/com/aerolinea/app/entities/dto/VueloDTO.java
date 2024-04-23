package com.aerolinea.app.entities.dto;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import lombok.Data;

@Data
public class VueloDTO {
    
    LocalDate fechaSalida;
    LocalDate fechaLlegada;
    String estado;
    int idAvion;
    int idDestino;

}
