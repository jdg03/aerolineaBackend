package com.aerolinea.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Aeropuerto;
import com.aerolinea.app.entities.dto.AeropuertoDTO;
import com.aerolinea.app.services.impl.AeropuertoServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/aeropuertos")
public class AeropuertoController {

    @Autowired
    private AeropuertoServiceImpl aeropuertoServiceImpl;

    @GetMapping("")
    public List<Aeropuerto> listarAeropuertos() {
        return this.aeropuertoServiceImpl.listaAeropuertos();
    }

    @PostMapping("/crear/{idCiudad}/{nombre}")
    public Aeropuerto crearAeropuerto(@PathVariable int idCiudad, @PathVariable String nombre ) {
        return this.aeropuertoServiceImpl.crearAeropuerto(idCiudad, nombre);
    }

    @GetMapping("/buscar")
    public Optional<Aeropuerto> buscarPorId(@PathVariable int id) {
        return this.aeropuertoServiceImpl.buscarAeropuerto(id);
    }

    @PutMapping("/actualizar")
    public Aeropuerto actualizarAeropuerto(@RequestBody Aeropuerto aeropuerto){

        return this.actualizarAeropuerto(aeropuerto);

    }

    @DeleteMapping("/actualizar")
    public Aeropuerto eliminarAeropuerto(@RequestBody Aeropuerto aeropuerto){

        return this.actualizarAeropuerto(aeropuerto);

    }

}
