package com.aerolinea.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.dto.AsientoDTO;
import com.aerolinea.app.services.impl.AsientoServiceImpl;

@RestController
@RequestMapping("/api/asientos")
public class AsientosController {

    @Autowired
    AsientoServiceImpl asientoServiceImpl;

    @PostMapping("/crear")
    public Asiento crearAsiento(@RequestBody AsientoDTO asientoDTO) {
       
        return this.asientoServiceImpl.crearAsiento(asientoDTO);
    }

    @GetMapping("/obtener")
    public List<Asiento> obtenerAsientos() {
        return this.asientoServiceImpl.obtenerAsientos();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Asiento> buscarPorId(@PathVariable int id){
        
        return this.asientoServiceImpl.buscarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public Asiento actualizar(@PathVariable int id, @RequestBody AsientoDTO asientoDTO){
        
        return this.asientoServiceImpl.actualizarAsiento(id, asientoDTO);
    }


    

    
}
