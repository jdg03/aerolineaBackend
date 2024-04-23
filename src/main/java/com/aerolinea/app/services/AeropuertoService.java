package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Aeropuerto;

public interface AeropuertoService {

    public Aeropuerto crearAeropuerto(int idCiudad, String nombre);

    public List<Aeropuerto> listaAeropuertos();

    public Optional<Aeropuerto> buscarAeropuerto(int id);
}
