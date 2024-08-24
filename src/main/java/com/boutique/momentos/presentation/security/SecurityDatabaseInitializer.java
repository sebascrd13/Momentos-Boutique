package com.boutique.momentos.presentation.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.boutique.momentos.persistence.datarepository.RoleDataRepository;
import com.boutique.momentos.persistence.datarepository.UserDataRepository;
import com.boutique.momentos.persistence.entity.Role;
import com.boutique.momentos.persistence.entity.User;

@Configuration
public class SecurityDatabaseInitializer {

    private final PasswordEncoder passwordEncoder;

    public SecurityDatabaseInitializer(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner initDatabase(UserDataRepository userRepository, RoleDataRepository roleRepository) {
        return args -> {
            if (roleRepository.count() == 0) {
                Role adminRole = new Role();
                adminRole.setName("Administrador");
                roleRepository.save(adminRole);

                Role userRole = new Role();
                userRole.setName("Cliente");
                roleRepository.save(userRole);

                User admin = new User();
                admin.setUsername("admin1");
                admin.setPassword(passwordEncoder().encode("contrasena123"));
                admin.setRole(adminRole);
                userRepository.save(admin);

                User user = new User();
                user.setUsername("usuario1");
                user.setPassword(passwordEncoder().encode("contrasena456"));
                user.setRole(userRole);
                userRepository.save(user);
            }
        };
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}