package com.aerolinea.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/obtener")
    public List<Avion> listarAviones() {
        return this.avionServiceImpl.listarAviones();
    }

    @PostMapping("/crear")
    public Avion crearAvion(@RequestBody AvionDTO avionDTO) {
        Avion avion = new Avion();
        avion.setFabricante(avionDTO.getFabricante());
        avion.setModelo(avionDTO.getModelo());
        avion.setCapacidad(avionDTO.getCapacidad());
        avion.setNombre(avionDTO.getNombre());
        return this.avionServiceImpl.crearAvion(avion);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Avion> buscarAvion(@PathVariable int id) {
        return this.avionServiceImpl.buscarAvion(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        return this.avionServiceImpl.eliminarPorId(id);
    }
    @PutMapping("/actualizar/{id}")
    public Avion actualizarAvion(@PathVariable int id, AvionDTO avionDTO){
        // Avion avionActualizar
        return null;
    }
}
