package com.boutique.momentos.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boutique.momentos.domain.domainentity.OrderDomain;
import com.boutique.momentos.domain.domainrepository.OrderDomainRepository;
import com.boutique.momentos.persistence.datarepository.OrderDataRepository;
import com.boutique.momentos.persistence.entity.Order;
import com.boutique.momentos.persistence.mapper.OrderMapper;

@Repository
public class OrderRepository implements OrderDomainRepository {

    @Autowired
    private OrderDataRepository orderDataRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderDomain> getAllOrders() {
        List<Order> orders = (List<Order>) orderDataRepository.findAll();
        return orderMapper.toOrdersDomain(orders);
    }

    @Override
    public Optional<OrderDomain> getOrderById(int domainOrderId) {
        return orderDataRepository.findById(domainOrderId).map(order -> orderMapper.toOrder(order));
    }

    @Override
    public List<OrderDomain> getOrdersByUserId(int userId) {
        List<Order> orders = orderDataRepository.findOrdersByOrderUserId(userId);
        return orderMapper.toOrdersDomain(orders);
    }

    @Override
    public OrderDomain createOrder(OrderDomain domainOrder) {
        Order order = orderMapper.toDomainOrder(domainOrder);
        return orderMapper.toOrder(orderDataRepository.save(order));
    }

    @Override
    public String getOrderStatus(int orderId, int userId) {
        return orderDataRepository.findById(orderId)
            .filter(order -> order.getOrderUserId() == userId)
            .map(order -> order.isOrderStatus() ? "Completado" : "Pendiente")
            .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado para el usuario con el id: " + userId));
    }

    @Override
    public void updateOrderStatus(int orderId, String newStatus) {
        Order order = orderDataRepository.findById(orderId)
            .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado con el id: " + orderId));
        order.setOrderStatus("Completado".equalsIgnoreCase(newStatus));
        orderDataRepository.save(order);
    }

    @Override
    public void deleteOrder(int domainOrderId) {
        orderDataRepository.deleteById(domainOrderId);
    }
}
