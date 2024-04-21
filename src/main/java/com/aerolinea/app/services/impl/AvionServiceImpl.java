package com.aerolinea.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.app.entities.Asiento;
import com.aerolinea.app.entities.Avion;
import com.aerolinea.app.entities.Clase;
import com.aerolinea.app.repositories.AsientoRepository;
import com.aerolinea.app.repositories.AvionRepository;
import com.aerolinea.app.repositories.ClaseRepository;
import com.aerolinea.app.services.AvionService;

@Service
public class AvionServiceImpl implements AvionService {

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private AsientoRepository asientoRepository;
    
    @Autowired
    private ClaseRepository claseRepository;

    @Override
    public Avion crearAvion(Avion avion) {
        // Guardar el avión en la base de datos
        Avion avionCreado = this.avionRepository.save(avion);

        
        Clase claseBasica = this.claseRepository.findById(3).get();
        Clase clasePremiun = this.claseRepository.findById(2).get();
        Clase primeraClase = this.claseRepository.findById(1).get();


        // Obtener la capacidad del avión
        int capacidad = avion.getCapacidad();
        
        // Calcular la cantidad de asientos para cada clase
        int cantidadBasica = (int) (capacidad * 0.6);
        int cantidadPremium = (int) (capacidad * 0.25);
        int cantidadPrimeraClase = (int) (capacidad * 0.15);
        
        // Crear los asientos para cada clase
        List<Asiento> listaAsientos = new ArrayList<>();

        // representa el numero de cada asiento
        int contador =0;

        // listaAsientos de Clase Primera Clase
        for (int i = 1; i <= cantidadPrimeraClase; i++) {
            Asiento asiento = new Asiento();
            asiento.setNumeroAsiento(contador);
            asiento.setEstado(true);
            asiento.setAvion(avionCreado);
            asiento.setClase(primeraClase);
            listaAsientos.add(asiento);

            contador++;
            this.asientoRepository.save(asiento);
        }

         // listaAsientos de Clase Premium
         for (int i = 1; i <= cantidadPremium; i++) {
            Asiento asiento = new Asiento();
            asiento.setNumeroAsiento(contador);
            asiento.setEstado(true);
            asiento.setAvion(avionCreado); 
            asiento.setClase(clasePremiun);
            listaAsientos.add(asiento);

            contador++;
            this.asientoRepository.save(asiento);
        }
        
        
        // listaAsientos de Clase Básica
        for (int i = 1; i <= cantidadBasica; i++) {
            Asiento asiento = new Asiento();
            asiento.setNumeroAsiento(contador);
            asiento.setEstado(true); // Estado inicial
            asiento.setAvion(avionCreado);
            asiento.setClase(claseBasica);
            listaAsientos.add(asiento);

            contador++;
            //guarda los aeintos en la base de datos
            this.asientoRepository.save(asiento);
        }
        
       
        
        
        // Asignar los listaAsientos al avión
        avionCreado.setAsiento(listaAsientos);
        
        // Guardar el avión con los listaAsientos en la base de datos
        avionCreado = this.avionRepository.save(avion);
        
        return avionCreado;
    }
    

    @Override
    public List<Avion> listarAviones() {
        return (List<Avion>) this.avionRepository.findAll();
    }

    @Override
    public Optional<Avion> buscarAvion(int id) {
        return this.avionRepository.findById(id);
    }

    @Override
    public String eliminarPorId(int id) {
        if(this.avionRepository.findById(id).isPresent()){
            this.avionRepository.deleteById(id);
            return "Avion Eliminado";
        }       
        return "El Avion no existe";
    }

    @Override
    public List<Asiento> obtenerAsientos(int idAvion) {
    
       
        Avion avion = avionRepository.findById(idAvion).orElse(null);
        if (avion != null) {
            // Retornar la lista de asientos asociados al avión
            return avion.getAsiento();
        } else {
            // Manejar el caso en que el avión no sea encontrado
           
            return null;
        }
       
    }

}
