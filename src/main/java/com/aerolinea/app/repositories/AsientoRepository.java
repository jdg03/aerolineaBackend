package com.aerolinea.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.Avion;

@Repository
public interface AsientoRepository extends CrudRepository<Asiento, Integer> {

  

}
