package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Vuelo;

public interface VueloService {

    public Vuelo crearVuelo(Vuelo vuelo);

    public List<Vuelo> listarVuelos();

    public Optional<Vuelo> buscarPorId(int id);

    public String eliminar(int id);



}