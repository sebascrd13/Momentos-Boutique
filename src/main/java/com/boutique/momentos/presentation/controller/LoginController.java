package com.boutique.momentos.presentation.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boutique.momentos.persistence.datarepository.UserDataRepository;
import com.boutique.momentos.persistence.entity.Role;
import com.boutique.momentos.persistence.entity.User;

@Controller
public class LoginController {

    @Autowired
    private UserDataRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String name,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String direccion,
            @RequestParam String ciudad,
            @RequestParam String telefono) {

        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty() || direccion.isEmpty() || ciudad.isEmpty() || telefono.isEmpty()) {
            return "register";
        }

        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setDireccion(direccion);
        user.setCiudad(ciudad);
        user.setTelefono(telefono);
        user.setFechaRegistro(LocalDate.now());

        Role role = new Role();
        role.setId(2);
        user.setRole(role);

        userRepository.save(user);

        return "redirect:/login";
    }
}