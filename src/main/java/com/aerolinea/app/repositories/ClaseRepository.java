package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Clase;

@Repository
public interface ClaseRepository extends CrudRepository <Clase, Integer> {
    
}
