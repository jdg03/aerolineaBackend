package com.aerolinea.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Venta;
import com.aerolinea.app.entities.dto.VentaDTO;
import com.aerolinea.app.services.impl.VentaServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    
    @Autowired
    VentaServiceImpl ventaServiceImpl;
   

    // el ventaDTO no lo lee del Json por eso los parametros en la url
    @PostMapping("/crear/{idCliente}/{precio}/{idVuelo}")
    public Venta crearVenta(@PathVariable int idCliente, @PathVariable int precio, @PathVariable int idVuelo){
        return this.ventaServiceImpl.crearVenta(idCliente,precio,idVuelo);
    }

    @GetMapping("/obtener")
    public List<Venta> obtenerVentas(){
        return this.ventaServiceImpl.obtenerVentas();
    }

    @GetMapping("/buscar")
    public Optional<Venta> buscarPorId(@RequestParam int id){
        return this.ventaServiceImpl.buscarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public Venta actualizarBoleto(@PathVariable int id, @RequestBody VentaDTO ventaDTO){
        return this.ventaServiceImpl.actualizarVenta(id, ventaDTO);
    }

    @DeleteMapping("/eliminar")
    public String eliminarPorId(@PathVariable int id){
        return this.ventaServiceImpl.eliminarPorId(id);
    }
}
