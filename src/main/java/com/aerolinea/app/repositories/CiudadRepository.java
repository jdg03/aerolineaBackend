package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Ciudad;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Integer> {

}
