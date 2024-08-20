package com.boutique.momentos.persistence.datarepository;

import com.boutique.momentos.persistence.entity.OrderProduct;
import com.boutique.momentos.persistence.entity.OrderProductId;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderProductDataRepository extends CrudRepository<OrderProduct, Integer> {
    List<OrderProduct> findByOrderOrderId(int orderId);
    List<OrderProduct> findByOrderUserId(int userId);
    Optional<OrderProduct> findById(OrderProductId id);
}
