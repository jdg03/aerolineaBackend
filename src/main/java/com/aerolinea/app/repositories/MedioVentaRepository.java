package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.MedioVenta;

@Repository
public interface MedioVentaRepository extends CrudRepository<MedioVenta, Integer> {

}
