package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Avion;

@Repository
public interface AvionRepository extends CrudRepository<Avion, Integer> {

}
    