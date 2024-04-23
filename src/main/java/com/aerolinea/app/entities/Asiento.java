package com.aerolinea.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name ="asientos")
@Data

public class Asiento {

    @Id
    @Column(name = "id_asiento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsiento;

    @Column(name = "numero_asiento")
    private int numeroAsiento;
    public boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_avion", referencedColumnName = "id_avion")
    //@JsonManagedReference
    @JsonBackReference //-
    @JsonIgnore
    private Avion avion;

    @OneToOne
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    private Clase clase;
    
}
