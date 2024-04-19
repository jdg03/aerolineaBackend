package com.aerolinea.app.services;

import java.util.List;
import java.util.Optional;

import com.aerolinea.app.entities.Boleto;

public interface BoletoService {
    
    public Boleto crearBoleto(Boleto boleto);

    public List<Boleto> obtenerBoletos();

    public Optional<Boleto> buscarPorId(int id);

    public Boleto actualizarBoleto(int id, Boleto boleto);

    public String eliminarPorId(int id);

}
