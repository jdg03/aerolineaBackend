package com.aerolinea.app.services.impl;

import java.time.LocalDate;
import java.util.Random;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Aeropuerto;
import com.aerolinea.app.entities.Avion;
import com.aerolinea.app.entities.Vuelo;
import com.aerolinea.app.repositories.AeropuertoRepository;
import com.aerolinea.app.repositories.AvionRepository;
import com.aerolinea.app.repositories.VueloRepository;
import com.aerolinea.app.services.VueloService;

@Service
public class VueloServiceImpl implements VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    @Autowired
    private AvionServiceImpl avionServiceImpl;

    @Autowired
    private AeropuertoServiceImpl aeropuertoServiceImpl;

    @Override
    public List<Vuelo> listarVuelos() {
        return (List<Vuelo>) this.vueloRepository.findAll();
    }

    @Override
    public Vuelo crearVuelo(int idAvion, int idAeropuertoSalida, int idAeropuertoLlegada) {
        // Avion avion = buscarAvion(idAvion);
        // Aeropuerto llegada = buscarAeropuertoLlegada(idAeropuertoLlegada);
        // Aeropuerto salida = buscarAeropuertoSalida(idAeropuertoSalida);
        // Vuelo nuevoVuelo = new Vuelo();
        // nuevoVuelo.setLlegada(llegada);
        // nuevoVuelo.setSalida(salida);
        // nuevoVuelo.setFechaSalida(LocalDate.now());
        // nuevoVuelo.setNumeroVuelo("MYA");
        // nuevoVuelo.setAvion(avion);
        return null;
    }

    public Avion buscarAvion(int id) {
        return this.avionRepository.findById(id).get();
    }

    public Aeropuerto buscarAeropuertoSalida(int id) {
        return this.aeropuertoRepository.findById(id).get();
    }

    public Aeropuerto buscarAeropuertoLlegada(int id) {
        return this.aeropuertoRepository.findById(id).get();
    }

    @Override
    public Optional<Vuelo> buscarPorId(int id) {
       
        return this.vueloRepository.findById(id);
    }



}
