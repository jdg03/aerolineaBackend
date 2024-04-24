package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Venta;
import com.aerolinea.app.entities.dto.VentaDTO;

public interface VentaService {

    public Venta crearVenta(int idCliente, int precio, int idVuelo);

    public List<Venta> obtenerVentas();

    public Optional<Venta> buscarPorId(int id);

    public Venta actualizarVenta(int id, VentaDTO venta);

    public String eliminarPorId(int id);
    
} 
