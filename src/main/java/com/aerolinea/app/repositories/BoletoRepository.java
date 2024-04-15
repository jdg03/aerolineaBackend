package com.aerolinea.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Boleto;

@Repository
public interface BoletoRepository extends CrudRepository<Boleto, Integer> {

}
