package com.aerolinea.app.entities;

import java.util.List;

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

    @OneToMany(mappedBy = "pais")
    private List<Ciudad> ciudades;

}
