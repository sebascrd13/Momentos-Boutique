package com.boutique.momentos.persistence.datarepository;

import org.springframework.data.repository.CrudRepository;

import com.boutique.momentos.persistence.entity.Category;

public interface CategoryDataRepository extends CrudRepository<Category, Integer> {
    
}
