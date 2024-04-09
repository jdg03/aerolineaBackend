package com.aerolinea.app.services;

import java.util.List;

import com.aerolinea.app.entities.Vuelo;

public interface VueloService {

    public Vuelo crearVuelo(int idAvion, int idAeropuertoSalida, int idAeropuertoLlegada);

    public List<Vuelo> listarVuelos();

}