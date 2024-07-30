package com.boutique.momentos.domain.domainrepository;

import java.util.List;
import java.util.Optional;

import com.boutique.momentos.domain.domainentity.ProductDomain;
import com.boutique.momentos.persistence.entity.User;

public interface ClientDomainRepository {
    List<User> getAllClients();
    ProductDomain saveProduct(ProductDomain product);
    Optional<User> getClientById(int clientId);
    void updateClient(ProductDomain product);
    void deleteProduct(int productId);
    
}
