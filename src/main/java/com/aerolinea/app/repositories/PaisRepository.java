package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Integer> {

}
