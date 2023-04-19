package com.example.lab4_20171198.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")

@Getter
@Setter
public class User {


    @Id
    private Integer iduser;

    @Column(name = "username")
    private String username;

    private String email;

    private String password;




}
