package com.aerolinea.app.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.app.entities.Cliente;
import com.aerolinea.app.entities.Venta;
import com.aerolinea.app.services.impl.ClienteServiceImpl;

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

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/crear")
    public Cliente crearUsuario(@RequestBody Cliente cliente) {
        return this.clienteServiceImpl.crearCliente(cliente);
    }

    @GetMapping("/obtener")
    public List<Cliente> obtenerCliente() {
        return this.clienteServiceImpl.obtenerCLientes();
    }

    @PutMapping("/actualizar/{id}")
    public Cliente actualizarCliente(@PathVariable int id,
            @RequestBody Cliente cliente) {
        return this.clienteServiceImpl.actualizarCliente(id, cliente);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable int id) {
        return this.clienteServiceImpl.buscarPorId(id);
    }

    @DeleteMapping("/eliminar")
    public String eliminarCliente(@RequestParam int id) {
        return this.clienteServiceImpl.eliminarPorId(id);
    }

    @GetMapping("/obtenerVentas/{idCliente}")
    public List<Venta> obtenerVentas(@PathVariable int idCliente) {

        return this.clienteServiceImpl.obtenerVentas(idCliente);
    }

    @GetMapping("/obtenerPorCorreo/{correo}")
    public Cliente obtenerPorCorreo(@PathVariable String correo) {

        return this.clienteServiceImpl.buscarPorCorreo(correo);
    }

}
