package com.aerolinea.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Avion;
import com.aerolinea.app.entities.dto.AvionDTO;
import com.aerolinea.app.services.impl.AvionServiceImpl;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/aviones")
public class AvionController {

    @Autowired
    private AvionServiceImpl avionServiceImpl;

    @GetMapping("")
    public List<Avion> listarAviones() {
        return this.avionServiceImpl.listarAviones();
    }

    @PostMapping("/crear")
    public Avion crearAvion(@RequestBody AvionDTO avionDTO) {
        Avion avion = new Avion();
        avion.setMarca(avionDTO.getMarca());
        avion.setAsientosBasico(avionDTO.getAsientosBasico());
        avion.setAsientosPremium(avionDTO.getAsientosPremium());
        avion.setAsientosPrimeraClase(avionDTO.getAsientosPrimeraClase());
        return this.avionServiceImpl.crearAvion(avion);
    }
}
