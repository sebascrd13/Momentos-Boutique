package com.boutique.momentos.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boutique.momentos.service.ClientService;

@Controller
public class HomeController {

    @Autowired
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