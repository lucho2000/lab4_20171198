package com.example.lab4_20171198.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "aerolinea")
@Getter
@Setter
public class Aerolinea {


    @Id
    @Column(name = "idaerolinea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAerolinea;

    @Column(name = "nombre")
    private String nombre;

    private String codigo;


}
