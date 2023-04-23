package com.example.lab4_20171198.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")

@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iduser;

    @Column(name = "username")
    private String username;

    private String email;

    private String password;




}
