package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Pais;
import com.aerolinea.app.repositories.PaisRepository;
import com.aerolinea.app.services.PaisService;

@Service
public class PaisServiceImpl implements PaisService{

    @Autowired
    PaisRepository paisRepository;

    @Override
    public Pais crearPais(Pais pais) {
        
        return this.paisRepository.save(pais);
        
    }

    @Override
    public List<Pais> obtenerPaises() {
       
       return (List<Pais>) this.paisRepository.findAll();
    }

    @Override
    public Optional<Pais> buscarPorId(int id) {
       
        return this.paisRepository.findById(id);
        
    }

    @Override
    public Pais actualizarPais(int id, Pais pais) {
        
        Pais paisActualizar = this.paisRepository.findById(id).get();

        if(null != paisActualizar){
            paisActualizar.setNombre(pais.getNombre());
            this.paisRepository.save(paisActualizar);
        }

        return paisActualizar;
    }

    @Override
    public String eliminarPorId(int id) {

        if(this.paisRepository.findById(id).isPresent()){
            this.paisRepository.deleteById(id);
            return "Pais Eliminado";
        }       

        return "El Pais no existe";
    }


    
}
