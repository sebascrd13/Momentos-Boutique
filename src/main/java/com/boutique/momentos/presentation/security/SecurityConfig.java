package com.boutique.momentos.presentation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.boutique.momentos.service.ClientService;
import com.boutique.momentos.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final CustomUserDetailsService userDetailsService;
    
    @Autowired
    private final ClientService clientService;

    public SecurityConfig(CustomUserDetailsService userDetailsService, ClientService clientService) {
        this.userDetailsService = userDetailsService;
        this.clientService = clientService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/", "/login.html", "/register.html", "/register").permitAll()
                .requestMatchers("/admin/**").hasAuthority("Administrador")
                .requestMatchers("/user/**").hasAuthority("Cliente")
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successHandler(customAuthenticationSuccessHandler())
                .permitAll())
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html")
                .permitAll())
            .csrf().disable();

        return http.build();
    }

    @Bean
    public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler(clientService);
    }
}