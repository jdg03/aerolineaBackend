package com.aerolinea.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Avion;
import com.aerolinea.app.services.impl.AvionServiceImpl;

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
    public Avion crearAvion(@RequestBody Avion avion) {
        return this.avionServiceImpl.crearAvion(avion);
    }
}
