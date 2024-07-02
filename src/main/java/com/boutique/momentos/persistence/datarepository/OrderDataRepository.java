package com.boutique.momentos.persistence.datarepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boutique.momentos.persistence.entity.Order;
import com.boutique.momentos.persistence.entity.Payment;

public interface OrderDataRepository extends CrudRepository<Order, Integer>{
    List<Order> findOrderByIdUser(Integer domainOrderId);
}
