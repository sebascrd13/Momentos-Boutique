package com.boutique.momentos.persistence.datarepository;

import org.springframework.data.repository.CrudRepository;

import com.boutique.momentos.persistence.entity.Product;
import com.boutique.momentos.persistence.entity.Role;

public interface ProductDataRepository extends CrudRepository<Product, Integer> {
    
}
