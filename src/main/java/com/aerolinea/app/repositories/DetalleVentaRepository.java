package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.DetalleVenta;

@Repository
public interface DetalleVentaRepository extends CrudRepository<DetalleVenta, Integer> {

}
