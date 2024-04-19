package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Destino;
import com.aerolinea.app.repositories.DestinoRepository;
import com.aerolinea.app.services.DestinoService;

@Service
public class DestinoServiceImpl implements DestinoService{

    @Autowired
    DestinoRepository destinoRepository;

    @Override
    public Destino crearDestino(Destino destino) {
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
            destinoActualizar.setVuelo(destino.getVuelo());
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
