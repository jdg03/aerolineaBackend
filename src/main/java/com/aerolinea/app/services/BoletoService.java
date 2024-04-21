package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Boleto;
import com.aerolinea.app.entities.dto.BoletoDTO;

public interface BoletoService {
    
    public Boleto crearBoleto(BoletoDTO boletoDTO);

    public List<Boleto> obtenerBoletos();

    public Optional<Boleto> buscarPorId(int id);

    public Boleto actualizarBoleto(int id, Boleto boleto);

    public String eliminarPorId(int id);

}
