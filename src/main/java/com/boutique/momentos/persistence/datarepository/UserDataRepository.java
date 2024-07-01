package com.boutique.momentos.persistence.datarepository;

import org.springframework.data.repository.CrudRepository;

import com.boutique.momentos.persistence.entity.User;

public interface UserDataRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
