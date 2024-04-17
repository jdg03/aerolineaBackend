package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Ciudad;

public interface CiudadService {

    public Ciudad crearCiudad(Ciudad ciudad);

    public List<Ciudad> obtenerCiudades();

    public Optional<Ciudad> buscarPorId(int id);

    public Ciudad actualizarCiudad(int id, Ciudad ciudad);

    public String eliminarPorId(int id);
    
} 
