package com.boutique.momentos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.momentos.domain.domainrepository.ClientDomainRepository;
import com.boutique.momentos.persistence.entity.User;

@Service
public class ClientService {

    @Autowired
    private ClientDomainRepository clientDomainRepository;

    public List<User> getAllClients(){
        return clientDomainRepository.getAllClients();
    }
    public User saveClient(User user){
        return clientDomainRepository.saveClient(user);
    }
    public Optional<User> getClientById(int userId){
        return clientDomainRepository.getClientById(userId);
    }
    public User updateClient(User user){
        Optional<User> existingUser = getClientById(user.getIdUser());
        if (existingUser.isPresent()) {
            clientDomainRepository.updateClient(user);
            return user;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public User getClientByUsername(String username) {
        return clientDomainRepository.getClientByUsername(username);
    }

    public boolean deleteClient(int userId){
        if (getClientById(userId).isPresent()){
            clientDomainRepository.deleteClient(userId);
            return true;
        } else {
            return false;
        }
    }
}
