package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Boleto;
import com.aerolinea.app.repositories.BoletoRepository;
import com.aerolinea.app.services.BoletoService;

@Service
public class BoletoServiceImpl implements BoletoService{

    @Autowired
    BoletoRepository boletoRepository;
    
    @Override
    public Boleto crearBoleto(Boleto boleto) {
        return this.boletoRepository.save(boleto);
    }

    @Override
    public List<Boleto> obtenerBoletos() {
        return (List<Boleto>) this.boletoRepository.findAll();
    }

    @Override
    public Optional<Boleto> buscarPorId(int id) {
        return this.boletoRepository.findById(id);
    }

    @Override
    public Boleto actualizarBoleto(int id, Boleto boleto) {
        Boleto boletoActualizar = this.boletoRepository.findById(id).get();

        if(null != boletoActualizar){
    
            boletoActualizar.setPrecioTotal(boleto.getPrecioTotal());
            boletoActualizar.setAsiento(boleto.getAsiento());
            boletoActualizar.setVuelo(boleto.getVuelo());
            this.boletoRepository.save(boletoActualizar);
        }

        return boletoActualizar;
    }

    @Override
    public String eliminarPorId(int id) {
        
        if(this.boletoRepository.findById(id).isPresent()){
            this.boletoRepository.deleteById(id);
            return "Boleto Eliminado";
        }
        
        return "El boleto no existe";
    }
}
