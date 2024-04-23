package com.aerolinea.app.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ventas")
public class Venta {

    @Id
    @Column(name = "id_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;

    private LocalDate fecha;

    private double total;

    private double descuento;

    private double impuesto;
    
    @Column(name = "sub_total")
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    //@JsonManagedReference
   // @OneToMany(mappedBy = "venta")
    //private List<DetalleVenta> detalleVentas;


}
