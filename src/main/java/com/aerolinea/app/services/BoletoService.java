package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Boleto;
import com.aerolinea.app.entities.dto.BoletoDTO;

public interface BoletoService {
    
    public BoletoDTO crearBoleto(BoletoDTO boletoDTO);

    public List<BoletoDTO> obtenerBoletos();

    public Optional<BoletoDTO> buscarPorId(int id);

    public Boleto actualizarBoleto(int id, Boleto boleto);

    public String eliminarPorId(int id);

}
