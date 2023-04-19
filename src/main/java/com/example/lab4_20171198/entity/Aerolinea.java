package com.example.lab4_20171198.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "aerolinea")
@Getter
@Setter
public class Aerolinea {


    @Id
    @Column(name = "idaerolinea")
    private Integer idAerolinea;

    @Column(name = "username")
    private String nombre;

    private String codigo;


}
