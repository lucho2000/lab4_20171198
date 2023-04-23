package com.example.lab4_20171198.controllers;


import com.example.lab4_20171198.entity.User;
import com.example.lab4_20171198.repository.UserRepository;
import com.example.lab4_20171198.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping("/login")
    public String inicio(){
        return "inicio";
    }
    @PostMapping ("/homepage")
    public String inicio(RedirectAttributes attr, @RequestParam("email") String correo, @RequestParam("contrasena") String contrasena){

            User user = userRepository.compararUsers(correo,contrasena);

            if (user != null){
                attr.addFlashAttribute("usr", user);
                return "redirect:/home";
            }
            else {
                return "redirect:/login";
            }
    }





}
