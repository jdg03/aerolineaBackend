package com.aerolinea.app.entities;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private LocalDate fechaLlegada;
    
    private String estado;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "id_avion", referencedColumnName = "id_avion")
    private Avion avion;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "id_destino", referencedColumnName = "id_destino")
    private Destino destino;

}
