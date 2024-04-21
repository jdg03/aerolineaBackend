package com.aerolinea.app.entities.dto;

import lombok.Data;

@Data
public class AsientoDTO {
    private int numeroAsiento;
    private boolean estado;

    //id de las entidades que se le asignaran al asiento
    private int idClase;
    private int idAvion;
}
