package com.aerolinea.app.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.app.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    Cliente findByCorreo(String correo);
    
}
