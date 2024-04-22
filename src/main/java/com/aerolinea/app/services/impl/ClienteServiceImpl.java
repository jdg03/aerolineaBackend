package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Cliente;
import com.aerolinea.app.entities.Venta;

import com.aerolinea.app.repositories.ClienteRepository;
import com.aerolinea.app.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerCLientes() {

        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(int id) {
        return this.clienteRepository.findById(id);
    }

    @Override
    public Cliente actualizarCliente(int id, Cliente cliente) {
        Cliente clienteActualizar = this.clienteRepository.findById(id).get();

        if(null != clienteActualizar){
            clienteActualizar.setNombre(cliente.getNombre());
            clienteActualizar.setCorreo(cliente.getCorreo());
            clienteActualizar.setTelefono(cliente.getTelefono());
            clienteActualizar.setDireccion(cliente.getDireccion());
            clienteActualizar.setNacionalidad(cliente.getNacionalidad());
            clienteActualizar.setPasaporte(cliente.getPasaporte());
            clienteActualizar.setClienteRegistrado(true);;
            this.clienteRepository.save(clienteActualizar);
        }

        return clienteActualizar;
    }

    @Override
    public String eliminarPorId(int id) {
        if(this.clienteRepository.findById(id).isPresent()){
            this.clienteRepository.deleteById(id);
            return "Cliente Eliminado";
        }       

        return "El Cliente no existe";
    }

    @Override
    public List<Venta> obtenerVentas(int idCliente) {
      
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente != null) {
            // Retornar la lista de asientos asociados al avión
            return (List<Venta>) cliente.getVentas();
        } else {
            // Manejar el caso en que el avión no sea encontrado
           
            return null;
        }
       
    }

    @Override
    public Cliente buscarPorCorreo(String correo) {
        Cliente cliente = clienteRepository.findByCorreo(correo);
        if (cliente == null) {
            return null;
        }
        return cliente;
    }
    }
