package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Cliente;

public interface ClienteService {
    public Cliente crearCliente(Cliente cliente);

    public List<Cliente> obtenerCLientes();

    public Optional<Cliente> buscarPorId(int id);

    public Cliente actualizarCliente(int id, Cliente cliente);

    public String eliminarPorId(int id);

}
