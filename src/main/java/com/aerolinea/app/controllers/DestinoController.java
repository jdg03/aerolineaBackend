package com.aerolinea.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Destino;
import com.aerolinea.app.entities.dto.DestinoDTO;
import com.aerolinea.app.services.impl.DestinoServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    @Autowired
    DestinoServiceImpl destinoServiceImpl;

    @PostMapping("/crear/{distancia}/{ciudadO}/{ciudadD}")
    public Destino crearDestino(@PathVariable int distancia, @PathVariable int ciudadO, @PathVariable int ciudadD){
        return this.destinoServiceImpl.crearDestino(distancia, ciudadO, ciudadD);
    }

    @GetMapping("/obtener")
    public List<Destino> obtenerDestinos(){
        return this.destinoServiceImpl.obtenerDestinos();
    }

    @GetMapping("/buscar")
    public Optional<Destino> buscarPorId(@RequestParam int id){
        return this.destinoServiceImpl.buscarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public Destino actualizarDestino(@PathVariable int id, @RequestBody Destino destino){
        return this.destinoServiceImpl.actualizarDestino(id, destino);
    }

    @DeleteMapping("/eliminar")
    public String eliminarPorId(@RequestParam int id){
        return this.destinoServiceImpl.eliminarPorId(id);
    }
}
