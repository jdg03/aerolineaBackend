package com.aerolinea.app.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "boletos")
public class Boleto {

    @Id
    @Column(name = "id_boleto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBoleto;
    private LocalDate fecha;
    private double precioTotal;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_asiento", referencedColumnName = "id_asiento")
    private Asiento asiento;

    @OneToOne
    @JoinColumn(name = "id_vuelo", referencedColumnName = "id_vuelo")
    private Vuelo vuelo;
}
