package com.boutique.momentos.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boutique.momentos.persistence.datarepository.UserDataRepository;
import com.boutique.momentos.persistence.entity.User;

@Controller
public class LoginController {

    @Autowired
    private UserDataRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return new ModelAndView("redirect:/home");
        } else {
            // Autenticación fallida
            return new ModelAndView("login").addObject("error", "Credenciales inválidas");
        }
    }
}