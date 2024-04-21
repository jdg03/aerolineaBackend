package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.dto.AsientoDTO;


public interface AsientoService {

    // recibe el los datos del dto en el body
    public Asiento crearAsiento(AsientoDTO asiento);

    public List<Asiento> obtenerAsientos();

    public Optional<Asiento> buscarPorId(int id);

    public Asiento actualizarAsiento(int id, AsientoDTO asiento);

    public String eliminarAsiento(int id);

    
}
