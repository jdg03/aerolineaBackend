package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Asiento;

@Repository
public interface AsientoRepository extends CrudRepository<Asiento, Integer> {

}
