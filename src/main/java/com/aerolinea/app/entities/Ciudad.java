package com.aerolinea.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
@Table(name = "ciudades")
@Data
public class Ciudad {

    @Id
    @Column(name = "id_ciudad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCiudad;
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    private Pais pais;


    @OneToOne(mappedBy = "ciudadOrigen")
    @JsonBackReference
    private Destino ciudadOrigen;

    
    @OneToOne(mappedBy = "ciudadDestino")
    @JsonBackReference
    private Destino ciudadDestino;

}
