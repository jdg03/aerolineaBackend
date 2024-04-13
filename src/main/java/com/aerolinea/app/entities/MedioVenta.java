package com.aerolinea.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "medio_venta")
@Data
public class MedioVenta {

    @Id
    @Column(name = "id_medio_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedioVenta;

}
