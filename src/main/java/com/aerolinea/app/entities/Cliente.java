package com.aerolinea.app.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")   
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private String nacionalidad;
    private String pasaporte;
    private boolean clienteRegistrado;

    @OneToMany(mappedBy = "cliente")
    @JsonBackReference
    //JsonIgnore
    private List<Venta> ventas;

}
