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

import com.aerolinea.app.entities.Boleto;
import com.aerolinea.app.entities.dto.BoletoDTO;
import com.aerolinea.app.services.impl.BoletoServiceImpl;


@RestController
@RequestMapping("/api/boletos")
public class BoletoController {
    
    @Autowired
    BoletoServiceImpl boletoServiceImpl;

    @PostMapping("/crear")
    public BoletoDTO crearBoleto(@RequestBody BoletoDTO boletoDTO){
        return this.boletoServiceImpl.crearBoleto(boletoDTO);
    }

    @GetMapping("/obtener")
    public List<BoletoDTO> obtenerBoletos(){
        return this.boletoServiceImpl.obtenerBoletos();
    }

    @GetMapping("/buscar/{id}")
    public Optional<BoletoDTO> buscarPorId(@PathVariable int id){
        return this.boletoServiceImpl.buscarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public Boleto actualizarBoleto(@PathVariable int id, @RequestBody Boleto boleto){
        return this.boletoServiceImpl.actualizarBoleto(id, boleto);
    }

    @DeleteMapping("/eliminar")
    public String eliminarPorId(@RequestParam int id){
        return this.boletoServiceImpl.eliminarPorId(id);
    }
}
