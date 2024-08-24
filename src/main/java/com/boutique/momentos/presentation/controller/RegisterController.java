package com.boutique.momentos.presentation.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boutique.momentos.persistence.datarepository.UserDataRepository;
import com.boutique.momentos.persistence.entity.Role;
import com.boutique.momentos.persistence.entity.User;

@Controller
public class RegisterController {

    @Autowired
    private UserDataRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {

        if (user.getName() == null || user.getUsername() == null || user.getPassword() == null ||
            user.getEmail() == null || user.getDireccion() == null || user.getCiudad() == null ||
            user.getTelefono() == null) {
            model.addAttribute("error", "Todos los campos son obligatorios.");
            return "register";
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setFechaRegistro(LocalDate.now());

        Role role = new Role();
        role.setId(2);
        user.setRole(role);

        userRepository.save(user);

        return "redirect:/login";
    }
}