package com.example.lab4_20171198.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity

@Table(name = "vuelo")
@Getter
@Setter
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvuelo")
    private Integer idVuelo;

    @Column(name = "origen")
    private String origen;

    private String destino;


    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @Column(name = "fecha_llegada")
    private Date fechaLlegada;


    private Integer duracion;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "aerolinea_idaerolinea")
    private Aerolinea aerolinea;


    @Column(name = "asientos_disponibles")
    private Integer asientosDisponibles;


    private String descripcion;




}
