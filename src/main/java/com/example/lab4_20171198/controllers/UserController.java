package com.example.lab4_20171198.controllers;


import com.example.lab4_20171198.entity.User;
import com.example.lab4_20171198.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UserController {

    final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //@GetMapping("/nuevo")
    /*public String nuevo() {
        return "hospital/nuevohospital";
    }*/
    @GetMapping("/homepage")
    public String homePage(Model model){

        return "/homePage";
    }


    @GetMapping("/")
    public String inicio(Model model){

        return "inicio";
    }

    @GetMapping("/")
    public String compararUsers(Model model, @RequestParam("name") String name, @RequestParam("contrasena") String contrasena ){

        model.addAttribute("users", userRepository.findAll());

        Optional<User> optUser = userRepository.compararUsers(name, contrasena);

        if (optUser.isPresent()) {
            User user = optUser.get();
            model.addAttribute("user", user);
            return "/homePage";
        } else {
            return "redirect:/inicio";
        }

    }


    @PostMapping("/guardar")
    public String guardar(User user) {
        userRepository.save(user);


        return "redirect:/listar";
    }


}
