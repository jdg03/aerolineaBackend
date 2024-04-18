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

import com.aerolinea.app.entities.Pais;
import com.aerolinea.app.entities.dto.PaisDTO;
import com.aerolinea.app.services.impl.PaisServiceImpl;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    PaisServiceImpl paisServiceImpl;

    @PostMapping("/crear")
    public Pais crearVuelo(@RequestBody PaisDTO paisDTO) {
        Pais pais = new Pais();
        pais.setNombre(paisDTO.getNombre());
        return this.paisServiceImpl.crearPais(pais);
    }

    @GetMapping("/obtener")
    public List<Pais> paises() {
        return this.paisServiceImpl.obtenerPaises();
    }

    @PutMapping("/actualizar/{id}")
    public Pais actualizarPais(@PathVariable int id, @RequestBody PaisDTO paisDTO) {
        Pais actualizarPais = this.paisServiceImpl.buscarPorId(id).get();
        if (actualizarPais != null) {
            actualizarPais.setNombre(paisDTO.getNombre());
            return this.paisServiceImpl.actualizarPais(id, actualizarPais);
        }
        return actualizarPais;
    }

    @GetMapping("/buscar/{id}")
    public Optional<Pais> buscarPorId(@PathVariable int id) {
        return this.paisServiceImpl.buscarPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPais(@PathVariable int id) {
        return this.paisServiceImpl.eliminarPorId(id);
    }

}
