package com.aerolinea.app.services.impl;

import java.time.LocalDate;
import java.util.Random;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Aeropuerto;
import com.aerolinea.app.entities.Avion;
import com.aerolinea.app.entities.Destino;
import com.aerolinea.app.entities.Vuelo;
import com.aerolinea.app.entities.dto.VueloDTO;
import com.aerolinea.app.repositories.AeropuertoRepository;
import com.aerolinea.app.repositories.AvionRepository;
import com.aerolinea.app.repositories.DestinoRepository;
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
    private DestinoRepository destinoRepository;
   

    @Override
    public List<Vuelo> listarVuelos() {
        return (List<Vuelo>) this.vueloRepository.findAll();
    }

    @Override
    public Vuelo crearVuelo(VueloDTO vueloDto) {

       Avion avion = this.avionRepository.findById(vueloDto.getIdAvion()).orElse(null);
       Destino destino = this.destinoRepository.findById(vueloDto.getIdDestino()).orElse(null);

       if (avion != null && destino != null) {
        Vuelo vuelo = new Vuelo();
        vuelo.setAvion(avion);
        vuelo.setDestino(destino);
        vuelo.setEstado(vueloDto.getEstado());
        vuelo.setFechaSalida(vueloDto.getFechaSalida());
        vuelo.setFechaLlegada(vueloDto.getFechaLlegada());


        vuelo = this.vueloRepository.save(vuelo);

        return this.vueloRepository.save(vuelo);
    } else {
        throw new RuntimeException("No se pudo crear el asiento");
    }
        
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

  
    @Override
    public String eliminar(int id) {
        try {
            Optional<Vuelo> vuelo = this.vueloRepository.findById(id);
    
            if (vuelo.isPresent()) {
                this.vueloRepository.deleteById(vuelo.get().getIdVuelo());
                return "Vuelo eliminado";
            } else {
                return "El vuelo no existe";
            }
        } catch (Exception ex) {
            // Manejo de la excepción
            return "Error al eliminar el vuelo: " + ex.getMessage();
        }
    }
    

}
