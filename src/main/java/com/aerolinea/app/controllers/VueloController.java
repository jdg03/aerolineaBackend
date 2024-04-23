package com.aerolinea.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Vuelo;
import com.aerolinea.app.entities.dto.VueloDTO;
import com.aerolinea.app.services.impl.VueloServiceImpl;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    @Autowired
    private VueloServiceImpl vueloServiceImpl;

    @GetMapping("/obtener")
    public List<Vuelo> vuelos() {
        return this.vueloServiceImpl.listarVuelos();
    }

    @PostMapping("/crear")
    public Vuelo crearVuelo(@RequestBody VueloDTO vueloDto) {
        return this.vueloServiceImpl.crearVuelo(vueloDto);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Vuelo> buscarPorId(@PathVariable int id) {
        return this.vueloServiceImpl.buscarPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        return this.vueloServiceImpl.eliminar(id);
    }


}
