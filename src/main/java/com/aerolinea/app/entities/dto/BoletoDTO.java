package com.aerolinea.app.entities.dto;



import lombok.Data;

@Data
public class BoletoDTO {

    private int idVuelo;
    private int idAsiento;
    private double precioTotal;
    
}
