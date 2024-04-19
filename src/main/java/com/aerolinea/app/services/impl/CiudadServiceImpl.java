package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Ciudad;
import com.aerolinea.app.entities.Pais;
import com.aerolinea.app.repositories.CiudadRepository;
import com.aerolinea.app.repositories.PaisRepository;
import com.aerolinea.app.services.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) {

        Pais pais = this.paisRepository.findById(ciudad.getPais().getIdPais()).get();
        ciudad.setPais(pais);
        return this.ciudadRepository.save(ciudad);
    }

    @Override
    public List<Ciudad> obtenerCiudades() {
        return (List<Ciudad>) this.ciudadRepository.findAll();
    }

    @Override
    public Optional<Ciudad> buscarPorId(int id) {
        return this.ciudadRepository.findById(id);
    }

    @Override
    public Ciudad actualizarCiudad(int id, Ciudad ciudad) {

        Ciudad ciudadActualizar = this.ciudadRepository.findById(id).get();

        if (null != ciudadActualizar) {
            ciudadActualizar.setNombre(ciudad.getNombre());
            this.ciudadRepository.save(ciudadActualizar);
        }
        return ciudadActualizar;
    }

    @Override
    public String eliminarPorId(int id) {
        if (this.ciudadRepository.findById(id).isPresent()) {
            this.ciudadRepository.deleteById(id);
            return "Ciudad Eliminada";
        }
        return "La ciudad no existe";
    }
}
