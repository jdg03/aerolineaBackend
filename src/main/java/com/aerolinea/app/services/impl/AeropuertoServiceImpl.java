package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Aeropuerto;
import com.aerolinea.app.entities.Ciudad;
import com.aerolinea.app.repositories.AeropuertoRepository;
import com.aerolinea.app.repositories.CiudadRepository;
import com.aerolinea.app.services.AeropuertoService;

@Service
public class AeropuertoServiceImpl implements AeropuertoService {

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public Aeropuerto crearAeropuerto(int idCiudad, String nombre) {
        Ciudad ciudad  = this.ciudadRepository.findById(idCiudad).get();
        Aeropuerto aeropuerto = new Aeropuerto();

        aeropuerto.setNombre(nombre);
        aeropuerto.setCiudad(ciudad);

        return this.aeropuertoRepository.save(aeropuerto);
    }

    @Override
    public List<Aeropuerto> listaAeropuertos() {
        return (List<Aeropuerto>) this.aeropuertoRepository.findAll();
    }

    @Override
    public Optional<Aeropuerto> buscarAeropuerto(int id) {
        return this.aeropuertoRepository.findById(id);
    }

}
