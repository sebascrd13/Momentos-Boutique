package com.boutique.momentos.domain.domainrepository;

import java.util.List;
import java.util.Optional;

import com.boutique.momentos.persistence.entity.User;

public interface ClientDomainRepository {
    List<User> getAllClients();
    User saveClient(User user);
    Optional<User> getClientById(int clientId);
    User getClientByUsername(String username);
    void updateClient(User user);
    void deleteClient(int clientId);
}
