package com.aerolinea.app.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String nombre;
    @ManyToOne
    // @JsonBackReference
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    private Ciudad ciudad;

}
