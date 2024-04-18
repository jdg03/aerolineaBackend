package com.aerolinea.app.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private String nombre;
    private String modelo;
    private int capacidad;
    private String fabricante;

    @OneToOne(mappedBy = "avion")
    @JsonBackReference
    private Vuelo vuelo;

    @OneToMany(mappedBy = "avion")
    @JsonBackReference
    private List<Asiento> asiento;

    

}
