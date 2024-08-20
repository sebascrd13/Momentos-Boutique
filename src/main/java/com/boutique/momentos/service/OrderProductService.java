package com.boutique.momentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.momentos.domain.domainrepository.OrderProductDomainRepository;
import com.boutique.momentos.persistence.entity.OrderProduct;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductDomainRepository orderProductDomainRepository;

    public List<OrderProduct> getOrderProductsByOrderId(int orderId) {
        return orderProductDomainRepository.getOrderProductsByOrderId(orderId);
    }

    public OrderProduct createOrderProduct(int orderId, OrderProduct orderProduct) {
        return orderProductDomainRepository.createOrderProduct(orderId, orderProduct);
    }
}