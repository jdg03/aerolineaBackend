package com.aerolinea.app.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @Column(name = "id_vuelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVuelo;
    private LocalDate fechaSalida;
    private String numeroVuelo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salida", referencedColumnName = "id_aeropuerto")
    private Aeropuerto salida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "llegada", referencedColumnName = "id_aeropuerto")
    private Aeropuerto llegada;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avion", referencedColumnName = "id_avion")
    private Avion avion;

}
