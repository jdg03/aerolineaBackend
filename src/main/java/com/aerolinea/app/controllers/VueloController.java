package com.aerolinea.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Vuelo;
import com.aerolinea.app.services.impl.AeropuertoServiceImpl;
import com.aerolinea.app.services.impl.AvionServiceImpl;
import com.aerolinea.app.services.impl.VueloServiceImpl;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    @Autowired
    private VueloServiceImpl vueloServiceImpl;
   

    @GetMapping("")
    public List<Vuelo> vuelos() {
        return this.vueloServiceImpl.listarVuelos();
    }

    @PostMapping("/crear")
    public Vuelo crearVuelo(@RequestBody Vuelo vuelo) {
        return this.vueloServiceImpl.crearVuelo(vuelo);
    }

}
