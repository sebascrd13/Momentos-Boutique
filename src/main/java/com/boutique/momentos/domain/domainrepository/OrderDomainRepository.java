package com.boutique.momentos.domain.domainrepository;

import java.util.List;
import java.util.Optional;

import com.boutique.momentos.domain.domainentity.OrderDomain;

public interface OrderDomainRepository {
    List<OrderDomain> getAllOrders();  // Obtener todos los pedidos como admin
    Optional<OrderDomain> getOrderById(int orderId);  // Obtener un pedido por ID como admin
    List<OrderDomain> getOrdersByUserId(int userId);  // Obtener pedidos por ID de usuario como admin
    OrderDomain createOrder(OrderDomain order);  // Realizar un pedido como usuario
    String getOrderStatus(int orderId, int userId);  // Obtener estado de un pedido como usuario
    void updateOrderStatus(int orderId, String newStatus);  // Actualizar estado de un pedido como admin
    void deleteOrder(int orderId);  // Eliminar un pedido como admin
}
