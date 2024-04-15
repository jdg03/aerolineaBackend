package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Destino;

@Repository
public interface DestinoRepository extends CrudRepository<Destino, Integer> {
    
}
