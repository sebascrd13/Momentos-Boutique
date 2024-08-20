package com.boutique.momentos.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boutique.momentos.domain.domainrepository.OrderProductDomainRepository;
import com.boutique.momentos.persistence.datarepository.OrderDataRepository;
import com.boutique.momentos.persistence.datarepository.OrderProductDataRepository;
import com.boutique.momentos.persistence.entity.Order;
import com.boutique.momentos.persistence.entity.OrderProduct;

import jakarta.persistence.EntityNotFoundException;

@Repository
public class OrderProductRepository implements OrderProductDomainRepository {

    @Autowired
    private OrderProductDataRepository orderProductDataRepository;

    @Autowired
    private OrderDataRepository orderDataRepository;

    @Override
    public List<OrderProduct> getOrderProductsByOrderId(int orderId) {
        return orderProductDataRepository.findByOrderOrderId(orderId);
    }

    @Override
    public OrderProduct createOrderProduct(int orderId, OrderProduct orderProduct) {
        Order order = orderDataRepository.findById(orderId)
            .orElseThrow(() -> new EntityNotFoundException("Order not found with ID: " + orderId));

        orderProduct.setOrder(order);

        return orderProductDataRepository.save(orderProduct);
    }
}
