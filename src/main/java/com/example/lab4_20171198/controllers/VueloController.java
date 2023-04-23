package com.example.lab4_20171198.controllers;

import com.example.lab4_20171198.repository.ReservaRepository;
import com.example.lab4_20171198.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class VueloController {

    final VueloRepository vueloRepository;

    final ReservaRepository reservaRepository;

    public VueloController(VueloRepository vueloRepository, ReservaRepository reservaRepository) {
        this.vueloRepository = vueloRepository;
        this.reservaRepository = reservaRepository;
    }

    @GetMapping("/home")
    public String inicio(Model model){

        model.addAttribute("listaVuelos",vueloRepository.findAll());
        return "homePage";
    }

    @PostMapping("/guardar")
    public String guardar(Integer id, String estado) {
        reservaRepository.cambioEstadoPago(estado, id); //llamamos al metodo para actualizar el registro

        return "redirect:/home";
    }
}
