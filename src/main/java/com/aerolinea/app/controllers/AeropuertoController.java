package com.aerolinea.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Aeropuerto;
import com.aerolinea.app.entities.dto.AeropuertoDTO;
import com.aerolinea.app.services.impl.AeropuertoServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/crear")
    public Aeropuerto crearAeropuerto(@RequestBody AeropuertoDTO aeropuertoDTO) {
        Aeropuerto aeropuerto = new Aeropuerto();
        aeropuerto.setCodigoIata(aeropuertoDTO.getCodigoIata());
        aeropuerto.setNombre(aeropuertoDTO.getNombre());
        aeropuerto.setPais(aeropuertoDTO.getPais());
        return this.aeropuertoServiceImpl.crearAeropuerto(aeropuerto);
    }

}
