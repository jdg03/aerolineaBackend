package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Pais;


public interface PaisService {

    public Pais crearPais(Pais pais);

    public List<Pais> obtenerPaises();

    public Optional<Pais> buscarPorId(int id);

    public Pais actualizarPais(int id, Pais pais);

    public String eliminarPorId(int id);
} 
