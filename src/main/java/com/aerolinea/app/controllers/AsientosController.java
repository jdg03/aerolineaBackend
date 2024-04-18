package com.aerolinea.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.services.impl.AsientoServiceImpl;

@RestController
@RequestMapping("/api/asientos")
public class AsientosController {

    @Autowired
    AsientoServiceImpl asientoServiceImpl;

    @PostMapping("/crear")
    public Asiento crearAsiento(@RequestBody Asiento asiento) {
       
        return this.asientoServiceImpl.crearAsiento(asiento);
    }

    @GetMapping("/obtener")
    public List<Asiento> obtenerAsientos() {
        return this.asientoServiceImpl.obtenerAsientos();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Asiento> buscarPorId(@PathVariable int id){
        
        return this.asientoServiceImpl.buscarPorId(id);
    }

    

    
}
