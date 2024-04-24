package com.aerolinea.app.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Cliente;
import com.aerolinea.app.entities.Venta;
import com.aerolinea.app.entities.Vuelo;
import com.aerolinea.app.entities.dto.VentaDTO;
import com.aerolinea.app.repositories.ClienteRepository;
import com.aerolinea.app.repositories.VentaRepository;
import com.aerolinea.app.repositories.VueloRepository;
import com.aerolinea.app.services.VentaService;
@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    VentaRepository ventaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VueloRepository vueloRepository;


    @Override
    // Al hacer la prueba no me leia los datos del Json, por eso le envie la informacion como parametro
    public Venta crearVenta(int idCliente, int precioClase, int idVuelo ) {

    // Obtener el cliente
    Cliente cliente = this.clienteRepository.findById(idCliente).get(); 

    //obtener el vuelo
    Vuelo vuelo = this.vueloRepository.findById(idVuelo).get();


    //precio segun la distancia
    double precioFinal = precioClase + (vuelo.getDestino().getDistancia()*0.07);

    // Verificar si el cliente existe
    if(cliente != null){

        // Calcular descuento, impuesto y subtotal
        double total = precioFinal;
        double descuento = 0;
        
        //aplica descuento si el cliente esta registrado
        if (cliente.isClienteRegistrado()) {

            descuento = total*0.05;
           
            
        }
        LocalDate fecha = LocalDate.now();

        double subtotal = total - descuento;
        double impuesto = subtotal * 0.15;
        total = subtotal + impuesto;

        // Crear la venta
        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setTotal(total);
        venta.setFecha(fecha);
        venta.setDescuento(descuento);
        venta.setImpuesto(impuesto);
        venta.setSubtotal(subtotal);

        // Guardar la venta en la base de datos
        venta = this.ventaRepository.save(venta);

        return venta;
    } else {
        throw new RuntimeException("No se pudo crear la venta. El cliente no existe.");
    }
}


    @Override
    public List<Venta> obtenerVentas() {
        
        return (List<Venta>) this.ventaRepository.findAll();
        
    }

    @Override
    public Optional<Venta> buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Venta actualizarVenta(int id, VentaDTO venta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarVenta'");
    }

    @Override
    public String eliminarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPorId'");
    }
    
}
