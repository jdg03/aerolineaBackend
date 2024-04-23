package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Ciudad;
import com.aerolinea.app.entities.Destino;
import com.aerolinea.app.entities.dto.DestinoDTO;
import com.aerolinea.app.repositories.CiudadRepository;
import com.aerolinea.app.repositories.DestinoRepository;
import com.aerolinea.app.services.DestinoService;

@Service
public class DestinoServiceImpl implements DestinoService{

    @Autowired
    DestinoRepository destinoRepository;

    @Autowired
    CiudadRepository ciudadRepository;

    @Override
public Destino crearDestino(int distancia, int ciudadO, int ciudadD) {

    Ciudad ciudadOrigen = this.ciudadRepository.findById(ciudadO).orElseThrow(() -> new RuntimeException("No se encontró la ciudad de origen con ID: " + ciudadO));
    Ciudad ciudadDestino = this.ciudadRepository.findById(ciudadD).orElseThrow(() -> new RuntimeException("No se encontró la ciudad de destino con ID: " + ciudadD));

    Destino destino = new Destino();
    destino.setCiudadOrigen(ciudadOrigen);
    destino.setCiudadDestino(ciudadDestino);
    destino.setDistancia(distancia);

    // Guardar el destino en la base de datos
    return this.destinoRepository.save(destino);
}


    @Override
    public List<Destino> obtenerDestinos() {
        return (List<Destino>) this.destinoRepository.findAll();    
    }

    @Override
    public Optional<Destino> buscarPorId(int id) {
        return this.destinoRepository.findById(id);
    }

    @Override
    public Destino actualizarDestino(int id, Destino destino) {
        Destino destinoActualizar = this.destinoRepository.findById(id).get();

        if(null != destinoActualizar){
            destinoActualizar.setDistancia(destino.getDistancia());
            destinoActualizar.setCiudadOrigen(destino.getCiudadOrigen());
            destinoActualizar.setCiudadDestino(destino.getCiudadDestino());
           // destinoActualizar.setVuelo(destino.getVuelo());
            this.destinoRepository.save(destinoActualizar);
        }

        return destinoActualizar;
    }

    @Override
    public String eliminarPorId(int id) {
        
        if(this.destinoRepository.findById(id).isPresent()){
            this.destinoRepository.deleteById(id);
            return "Destino Eliminado";
        }

        return "El destino no existe";
    }    
}
