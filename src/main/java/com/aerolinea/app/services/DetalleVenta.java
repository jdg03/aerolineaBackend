package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Venta;

public interface DetalleVenta {
    
    public DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta);

    public List<DetalleVenta> obtenerDetalleVenta();

    public Optional<Venta> buscarPorId(int id);

    public Venta actualizarDetalleVenta(int id, DetalleVenta detalleVenta);

    public String eliminarPorId(int id);
}
