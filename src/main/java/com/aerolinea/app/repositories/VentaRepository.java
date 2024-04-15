package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Venta;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Integer> {

}
