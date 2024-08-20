package com.boutique.momentos.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boutique.momentos.persistence.datarepository.UserDataRepository;
import com.boutique.momentos.persistence.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserDataRepository userDataRepository;

    public CustomUserDetailsService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDataRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
                return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()))
        );
    }
}