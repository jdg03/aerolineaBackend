package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Venta;

public interface VentaService {

    public Venta crearVenta(Venta venta);

    public List<Venta> obtenerVentas();

    public Optional<Venta> buscarPorId(int id);

    public Venta actualizarVenta(int id, Venta venta);

    public String eliminarPorId(int id);
    
} 
