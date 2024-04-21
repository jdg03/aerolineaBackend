package com.aerolinea.app.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "paises")
public class Pais {

    @Id
    @Column(name = "id_pais")
    private int idPais;
    private String nombre;

    @JsonManagedReference
    @OneToMany(mappedBy = "pais")
    private List<Ciudad> ciudades;

}
