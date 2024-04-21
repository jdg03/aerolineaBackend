package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.Avion;
import com.aerolinea.app.entities.Clase;
import com.aerolinea.app.entities.dto.AsientoDTO;
import com.aerolinea.app.repositories.AsientoRepository;
import com.aerolinea.app.repositories.AvionRepository;
import com.aerolinea.app.repositories.ClaseRepository;
import com.aerolinea.app.services.AsientoService;

@Service
public class AsientoServiceImpl implements AsientoService {


    @Autowired
    AsientoRepository asientoRepository;

    @Autowired
    AvionRepository avionRepository;

    @Autowired
    ClaseRepository claseRepository;

    @Override
    public Asiento crearAsiento(AsientoDTO asientoDTO) {

        // entidades que se le asignaran al asiento
        Avion avion = this.avionRepository.findById(asientoDTO.getIdAvion()).orElse(null);
        Clase clase = this.claseRepository.findById(asientoDTO.getIdClase()).orElse(null);

        if (avion != null && clase != null) {
            Asiento asiento = new Asiento();
            asiento.setNumeroAsiento(asientoDTO.getNumeroAsiento());
            asiento.setEstado(asientoDTO.isEstado());
            asiento.setAvion(avion);
            asiento.setClase(clase);

            asiento = this.asientoRepository.save(asiento);

            return asiento;
        } else {
            throw new RuntimeException("No se pudo crear el asiento");
        }
  
    }

    @Override
    public List<Asiento> obtenerAsientos() {
        
        return (List<Asiento>) this.asientoRepository.findAll();
       
    }

    @Override
    public Optional<Asiento> buscarPorId(int id) {
       
        return asientoRepository.findById(id);
    }

    @Override
    public Asiento actualizarAsiento(int id, AsientoDTO asientoDTO) {
        Asiento asientoActualizar = this.asientoRepository.findById(id).get();
    
        if (asientoActualizar != null) {
            // Actualizar los campos del asiento
           
           asientoActualizar.setEstado(asientoDTO.isEstado());
            
           // asientoActualizar.setClase(nuevoAsiento.getClase());
    
            // Guardar los cambios en la base de datos
            this.asientoRepository.save(asientoActualizar);
        }
    
        return asientoActualizar;
    }
    

    @Override
    public String eliminarAsiento(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarAsiento'");
    }

    
    
}
