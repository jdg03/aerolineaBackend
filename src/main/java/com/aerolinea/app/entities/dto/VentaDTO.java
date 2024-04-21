package com.aerolinea.app.entities.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VentaDTO {


    private int idVenta;
    private int idCliente;
    private LocalDate fecha;
    private double total;
    private double descuento;
    private double impuesto;
    private double subTotal;

}
