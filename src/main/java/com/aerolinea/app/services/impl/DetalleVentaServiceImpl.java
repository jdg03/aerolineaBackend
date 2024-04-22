package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Venta;
import com.aerolinea.app.repositories.DetalleVentaRepository;
import com.aerolinea.app.services.DetalleVenta;

@Service
public class DetalleVentaServiceImpl implements DetalleVenta{

    @Autowired
    DetalleVentaRepository detalleVentaRepository;

    @Override
    public DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearDetalleVenta'");
    }

    @Override
    public List<DetalleVenta> obtenerDetalleVenta() {
        
        
        throw new UnsupportedOperationException("Unimplemented method 'crearDetalleVenta'");
    }

    @Override
    public Optional<Venta> buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Venta actualizarDetalleVenta(int id, DetalleVenta detalleVenta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarDetalleVenta'");
    }

    @Override
    public String eliminarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPorId'");
    }
    
}
