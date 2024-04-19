package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Destino;

public interface DestinoService {
    
    public Destino crearDestino(Destino destino);

    public List<Destino> obtenerDestinos();

    public Optional<Destino> buscarPorId(int id);

    public Destino actualizarDestino(int id, Destino destino);

    public String eliminarPorId(int id);
}
