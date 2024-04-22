package com.aerolinea.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.Boleto;
import com.aerolinea.app.entities.Vuelo;
import com.aerolinea.app.entities.dto.BoletoDTO;
import com.aerolinea.app.repositories.AsientoRepository;
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
    public BoletoDTO crearBoleto(BoletoDTO boletoDTO) {

        Vuelo vuelo = this.vueloRepository.findById(boletoDTO.getIdVuelo()).get();
        Asiento asiento = this.asientoRepository.findById(boletoDTO.getIdAsiento()).get();

        if(vuelo != null && asiento !=null ){

            Boleto boleto = new Boleto();
            boleto.setPrecioTotal(asiento.getClase().getPrecio());
            boleto.setVuelo(vuelo);
            boleto.setAsiento(asiento);

            boleto = this.boletoRepository.save(boleto);

            //retorna un DTO
            BoletoDTO boletoResponse = new BoletoDTO();
            boletoResponse.setIdVuelo(boleto.getVuelo().getIdVuelo());
            boletoResponse.setIdAsiento(boleto.getAsiento().getIdAsiento());
            //debe ser otro precio
           boletoResponse.setPrecioTotal(boleto.getPrecioTotal());

        return boletoResponse;

        } else {
            throw new RuntimeException("No se pudo crear el boleto");
        }
    }

    @Override
    public List<BoletoDTO> obtenerBoletos() {
        List<Boleto> boletos = (List<Boleto>) this.boletoRepository.findAll();
        List<BoletoDTO> boletosDTO = new ArrayList<>();

        for (Boleto boleto : boletos) {
            BoletoDTO boletoDTO = new BoletoDTO();
            boletoDTO.setIdVuelo(boleto.getVuelo().getIdVuelo());
            boletoDTO.setIdAsiento(boleto.getAsiento().getIdAsiento());
            boletoDTO.setPrecioTotal(boleto.getPrecioTotal());

            boletosDTO.add(boletoDTO);
        }

        return boletosDTO;
    }

    @Override
    public Optional<BoletoDTO> buscarPorId(int id) {
        Boleto boleto = this.boletoRepository.findById(id).get();
        if (boleto!=null) {
       
        BoletoDTO boletoDTO = new BoletoDTO();
        boletoDTO.setIdVuelo(boleto.getVuelo().getIdVuelo());
        boletoDTO.setIdAsiento(boleto.getAsiento().getIdAsiento());
        boletoDTO.setPrecioTotal(boleto.getPrecioTotal());
        
        return Optional.of(boletoDTO);

     } else {
        return Optional.empty();
     }
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
