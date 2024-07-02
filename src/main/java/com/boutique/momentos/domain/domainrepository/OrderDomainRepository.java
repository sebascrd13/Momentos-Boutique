package com.boutique.momentos.domain.domainrepository;

import java.util.List;
import java.util.Optional;

import com.boutique.momentos.domain.domainentity.OrderDomain;

public interface OrderDomainRepository {
    List<OrderDomain> getAllOrders();
    Optional<OrderDomain> getOrderById(int orderId);
    List<OrderDomain> getOrdersByUserId(int userId);
    OrderDomain createOrder(OrderDomain order);
    String getOrderStatus(int orderId, int userId);
    void updateOrderStatus(int orderId, String newStatus);
    void deleteOrder(int orderId);
}
