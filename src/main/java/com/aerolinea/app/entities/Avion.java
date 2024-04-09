package com.aerolinea.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "aviones")
public class Avion {

    @Id
    @Column(name = "id_avion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAvion;
    private String marca;
    private int asientosPrimeraClase;
    private int asientosPremium;
    private int asientosBasico;

}
