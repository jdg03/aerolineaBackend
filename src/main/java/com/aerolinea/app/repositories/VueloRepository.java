package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Vuelo;

@Repository
public interface VueloRepository extends CrudRepository<Vuelo, Integer> {

}
