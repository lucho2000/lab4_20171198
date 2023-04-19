package com.example.lab4_20171198.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity

@Table(name = "reserva")
@Getter
@Setter
public class Reserva {


    @Id
    @Column(name = "idreserva")
    private Integer idReserva;

    @Column(name = "fecha_reserva")
    private String fechaReserva;

    @Column(name = "precio_total")
    private Double precioTotal;

    @Column(name = "estado_pago")
    private String estadoPago;


    @JoinColumn(name = "user_iduser")
    @ManyToOne
    private User user;

    @JoinColumn(name = "vuelo_idvuelo")
    @ManyToOne
    private Vuelo vuelo;

}
