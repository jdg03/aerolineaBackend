package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.Avion;

public interface AsientoService {

    public Asiento crearAsiento(Asiento asiento);

    public List<Asiento> obtenerAsientos();

    public Optional<Asiento> buscarPorId(int id);

    public Asiento actualizarAsiento(int id, Asiento asiento);

    public String eliminarAsiento(int id);

    
}
