package com.boutique.momentos.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boutique.momentos.persistence.entity.User;
import com.boutique.momentos.service.ClientService;

@Controller
public class HomeController {

    private final ClientService clientService;

    @Autowired
    public HomeController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/indexAdmin")
    public String indexAdmin(Model model) {
        return "indexAdmin";
    }
}