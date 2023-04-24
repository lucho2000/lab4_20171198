package com.example.lab4_20171198.controllers;

import com.example.lab4_20171198.entity.Reserva;
import com.example.lab4_20171198.entity.User;
import com.example.lab4_20171198.entity.Vuelo;
import com.example.lab4_20171198.repository.ReservaRepository;
import com.example.lab4_20171198.repository.UserRepository;
import com.example.lab4_20171198.repository.VueloRepository;
import jdk.jshell.execution.LocalExecutionControl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;


@Controller
public class VueloController {

    final VueloRepository vueloRepository;
    final UserRepository userRepository;

    final ReservaRepository reservaRepository;

    public VueloController(VueloRepository vueloRepository, ReservaRepository reservaRepository, UserRepository userRepository) {
        this.vueloRepository = vueloRepository;
        this.reservaRepository = reservaRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/home")
    public String inicio(Model model){

        model.addAttribute("listaVuelos",vueloRepository.findAll());
        return "homePage";
    }

    @GetMapping("/guardar")
    public String guardar(Integer id, Integer user, RedirectAttributes attr) {
        Vuelo vuelo = vueloRepository.findById(id).get();
        User user1 = userRepository.findById(user).get();
        Reserva reserva = new Reserva();
        reserva.setVuelo(vuelo);
        reserva.setUser(user1);
        reserva.setFechaReserva(LocalDateTime.now().toString());
        reserva.setPrecioTotal(vuelo.getPrecio());
        reserva.setEstadoPago("procesado");
        reservaRepository.save(reserva);
        attr.addFlashAttribute("modal", "S");
        attr.addFlashAttribute("usr", user1);
        return "redirect:/home";
    }
}
