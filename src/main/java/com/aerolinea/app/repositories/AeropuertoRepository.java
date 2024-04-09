package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Aeropuerto;

@Repository
public interface AeropuertoRepository extends CrudRepository<Aeropuerto, Integer> {

}
