package com.boutique.momentos.presentation.security;

import org.apache.commons.logging.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.boutique.momentos.persistence.entity.User;
import com.boutique.momentos.service.ClientService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final ClientService clientService; // Agrega el UserService para acceder a los datos del usuario

    public CustomAuthenticationSuccessHandler(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        System.out.println(username);

        User user = clientService.getClientByUsername(username);

        String redirectUrl;
        if (user.getRole().getId() == 1) {
            redirectUrl = "/indexAdmin.html";
        } else if (user.getRole().getId() == 2) {
            redirectUrl = "/index.html";
        } else {
            redirectUrl = "/login.html";
        }

        response.sendRedirect(redirectUrl);
    }
}