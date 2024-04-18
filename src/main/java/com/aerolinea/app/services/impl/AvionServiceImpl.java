package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.Avion;
import com.aerolinea.app.repositories.AsientoRepository;
import com.aerolinea.app.repositories.AvionRepository;
import com.aerolinea.app.services.AvionService;

@Service
public class AvionServiceImpl implements AvionService {

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private AsientoRepository asientoRepository;

    @Override
    public Avion crearAvion(Avion avion) {
        return this.avionRepository.save(avion);
    }

    @Override
    public List<Avion> listarAviones() {
        return (List<Avion>) this.avionRepository.findAll();
    }

    @Override
    public Optional<Avion> buscarAvion(int id) {
        return this.avionRepository.findById(id);
    }

    @Override
    public String eliminarPorId(int id) {
        if(this.avionRepository.findById(id).isPresent()){
            this.avionRepository.deleteById(id);
            return "Avion Eliminado";
        }       
        return "El Avion no existe";
    }

    @Override
    public List<Asiento> obtenerAsientos(int idAvion) {
    
       
        Avion avion = avionRepository.findById(idAvion).orElse(null);
        if (avion != null) {
            // Retornar la lista de asientos asociados al avión
            return avion.getAsiento();
        } else {
            // Manejar el caso en que el avión no sea encontrado
           
            return null;
        }
       
    }

}
