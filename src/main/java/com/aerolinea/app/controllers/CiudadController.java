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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Ciudad;
import com.aerolinea.app.entities.Pais;
import com.aerolinea.app.services.impl.CiudadServiceImpl;
import com.aerolinea.app.services.impl.PaisServiceImpl;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    @Autowired
    private CiudadServiceImpl ciudadServiceImpl;

    @PostMapping("/crear")
    public Ciudad crearCiudad(@RequestBody Ciudad ciudad) {
        
        System.out.println(ciudad);
        return this.ciudadServiceImpl.crearCiudad(ciudad);
    }

    @GetMapping("")
    public List<Ciudad> paises() {
        return this.ciudadServiceImpl.obtenerCiudades();
    }

    @PutMapping("/actualizar/{id}")
    public Ciudad actualizarCiudad(@PathVariable int id, @RequestBody Ciudad ciudad) {
        return this.ciudadServiceImpl.actualizarCiudad(id, ciudad);
    }

    @GetMapping("/buscar")
    public Optional<Ciudad> buscarPorId(@RequestParam int id) {
        return this.ciudadServiceImpl.buscarPorId(id);
    }

    @DeleteMapping("/eliminar")
    public String eliminarPais(@RequestParam int id) {
        return this.ciudadServiceImpl.eliminarPorId(id);
    }

}
