package com.aerolinea.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "clases")
@Data
public class Clase {

    @Id
    @Column(name = "id_clase")
    private int idClase;
    private String nombre;
    private int precio;

}
