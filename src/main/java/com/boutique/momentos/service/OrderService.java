package com.boutique.momentos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.boutique.momentos.domain.domainentity.OrderDomain;
import com.boutique.momentos.domain.domainrepository.OrderDomainRepository;

public class OrderService {
    
    @Autowired
    private OrderDomainRepository orderDomainRepository;

    public List<OrderDomain> getAllOrders(){
        return orderDomainRepository.getAllOrders();
    }
    public Optional<OrderDomain> getOrderById(int domainOrderId){
        return orderDomainRepository.getOrderById(domainOrderId);
    }
    public List<OrderDomain> getOrdersByUserId(int domainUserId){
        return orderDomainRepository.getOrdersByUserId(domainUserId);
    }
    public OrderDomain createOrder(OrderDomain domainOrder){
        return orderDomainRepository.createOrder(domainOrder);
    }
    public String getOrderStatus(int domainOrderId, int domainUserId){
        return orderDomainRepository.getOrderStatus(domainOrderId, domainUserId);
    }
    public boolean updateOrderStatus(int domainOrderId, String newStatus){
        if (orderDomainRepository.getOrderById(domainOrderId).isPresent()) {
            orderDomainRepository.updateOrderStatus(domainOrderId, newStatus);
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteOrder(int domainOrderId){
        if (getOrderById(domainOrderId).isPresent()){
            orderDomainRepository.deleteOrder(domainOrderId);
            return true;
        } else {
            return false;
        }
    }
}
