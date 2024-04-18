package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.Avion;

public interface AvionService {
    public Avion crearAvion(Avion avion);

    public List<Avion> listarAviones();

    public Optional<Avion> buscarAvion(int id);

    public String eliminarPorId(int id);

    public List<Asiento> obtenerAsientos(int idAvion);
}
