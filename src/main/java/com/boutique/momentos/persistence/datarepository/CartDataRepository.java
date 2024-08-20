package com.boutique.momentos.persistence.datarepository;

import com.boutique.momentos.persistence.entity.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartDataRepository extends CrudRepository<Cart, Integer> {
    List<Cart> findByCartUserId(Integer cartUserId);
    Optional<Cart> findByCartUserIdAndCartProductId(Integer cartUserId, Integer cartProductId);
}
