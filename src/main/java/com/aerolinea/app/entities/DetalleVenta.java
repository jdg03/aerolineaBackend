package com.aerolinea.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Data
@Table(name = "detalle_ventas")
public class DetalleVenta {

    @Id
    @Column(name = "id_detalle_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleVenta;
    @Column(name = "cantidad_boletos")
    private int cantidadBoletos;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_medio_venta", referencedColumnName = "id_medio_venta")
    private MedioVenta medioVenta;

    @OneToOne
    @JoinColumn(name = "id_boleto", referencedColumnName = "id_boleto")
    private Boleto boleto;
}
