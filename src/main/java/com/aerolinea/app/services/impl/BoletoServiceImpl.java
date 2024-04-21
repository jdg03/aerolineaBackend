package com.aerolinea.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.Boleto;
import com.aerolinea.app.entities.Vuelo;
import com.aerolinea.app.entities.dto.BoletoDTO;
import com.aerolinea.app.repositories.AsientoRepository;
import com.aerolinea.app.repositories.AvionRepository;
import com.aerolinea.app.repositories.BoletoRepository;
import com.aerolinea.app.repositories.VueloRepository;
import com.aerolinea.app.services.BoletoService;

@Service
public class BoletoServiceImpl implements BoletoService{

    @Autowired
    BoletoRepository boletoRepository;

    @Autowired
    VueloRepository vueloRepository;

    @Autowired
    AsientoRepository asientoRepository;
    
    @Override
    public Boleto crearBoleto(BoletoDTO boletoDTO) {

        Vuelo vuelo = this.vueloRepository.findById(boletoDTO.getIdVuelo()).get();
        Asiento asiento = this.asientoRepository.findById(boletoDTO.getIdAsiento()).get();

        if(vuelo != null && asiento !=null ){

            Boleto boleto = new Boleto();
            boleto.setPrecioTotal(boletoDTO.getPrecionTotal());
            boleto.setVuelo(vuelo);
            boleto.setAsiento(asiento);

            boleto = this.boletoRepository.save(boleto);

            return boleto;

        } else {
            throw new RuntimeException("No se pudo crear el boleto");
        }
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
