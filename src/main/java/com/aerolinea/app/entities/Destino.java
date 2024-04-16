package com.aerolinea.app.entities;

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
@Table(name = "destinos")
@Data
public class Destino {

    @Id
    @Column(name = "id_destino")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDestino;
    
    private int distancia;

    @OneToOne
    @JoinColumn(name = "id_ciudad_destino", referencedColumnName = "id_ciudad")
    private Ciudad ciudadDestino;
    @OneToOne
    @JoinColumn(name = "id_ciudad_origen", referencedColumnName = "id_ciudad")
    private Ciudad ciudadOrigen;

}
