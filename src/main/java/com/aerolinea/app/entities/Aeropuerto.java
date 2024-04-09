package com.aerolinea.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "aeropuertos")
public class Aeropuerto {

    @Id
    @Column(name = "id_aeropuerto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAeropuerto;
    @Column(name = "codigo_iata")
    private String codigoIata;
    private String nombre;
    private String pais;

}
