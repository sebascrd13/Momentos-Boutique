package com.boutique.momentos.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boutique.momentos.domain.domainrepository.ClientDomainRepository;
import com.boutique.momentos.persistence.datarepository.UserDataRepository;
import com.boutique.momentos.persistence.entity.User;

@Repository
public class ClientRepository implements ClientDomainRepository {

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    public List<User> getAllClients() {
        return (List<User>) userDataRepository.findAll();
    }

    @Override
    public User saveClient(User user) {
        return userDataRepository.save(user);
    }

    @Override
    public Optional<User> getClientById(int clientId) {
        return userDataRepository.findById(clientId);
    }

    public User getClientByUsername(String username) {
        return userDataRepository.findByUsername(username);
    }

    @Override
    public void updateClient(User user) {
        userDataRepository.save(user);
    }

    @Override
    public void deleteClient(int clientId) {
        userDataRepository.deleteById(clientId);
    }
}
