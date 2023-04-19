package com.example.lab4_20171198.controllers;


import com.example.lab4_20171198.entity.User;
import com.example.lab4_20171198.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/")
    public String homePage(Model model){

        return "homePage";
    }


    @GetMapping("/inicio")
    public String inicio(Model model){

        return "inicio";
    }

    @PostMapping("/guardar")
    public String guardar(User user) {
        userRepository.save(user);


        return "redirect:/listar";
    }


}
