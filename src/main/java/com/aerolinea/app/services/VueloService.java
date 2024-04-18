package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Vuelo;

public interface VueloService {

    public Vuelo crearVuelo(int idAvion, int idAeropuertoSalida, int idAeropuertoLlegada);

    public List<Vuelo> listarVuelos();

    public Optional<Vuelo> buscarPorId(int id);



}