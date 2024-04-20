package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.Avion;
import com.aerolinea.app.repositories.AsientoRepository;
import com.aerolinea.app.services.AsientoService;

@Service
public class AsientoServiceImpl implements AsientoService {


    @Autowired
    AsientoRepository asientoRepository;

    @Override
    public Asiento crearAsiento(Asiento asiento) {
       
        return this.asientoRepository.save(asiento);
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
    public Asiento actualizarAsiento(int id, Asiento nuevoAsiento) {
        Asiento asientoActualizar = this.asientoRepository.findById(id).orElse(null);
    
        if (asientoActualizar != null) {
            // Actualizar los campos del asiento
            //asientoActualizar.setNumeroAsiento(nuevoAsiento.getNumeroAsiento());
            asientoActualizar.setEstado(nuevoAsiento.estado);
            
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
