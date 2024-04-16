package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Avion;
import com.aerolinea.app.repositories.AvionRepository;
import com.aerolinea.app.services.AvionService;

@Service
public class AvionServiceImpl implements AvionService {

    @Autowired
    private AvionRepository avionRepository;

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

}
