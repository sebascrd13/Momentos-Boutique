package com.boutique.momentos.presentation.controller;

import java.util.Optional;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.momentos.domain.domainentity.OrderDomain;
import com.boutique.momentos.persistence.entity.User;
import com.boutique.momentos.service.ClientService;
import com.boutique.momentos.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<OrderDomain>> getAllOrders() {
        List<OrderDomain> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<OrderDomain> createOrder(
            @RequestParam("orderLocation") String orderLocation,
            @RequestParam("orderDescription") String orderDescription,
            @RequestParam("orderPaymentId") int orderPaymentId,
            Principal principal) {

        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setDomainOrderLocation(orderLocation);
        orderDomain.setDomainOrderDescription(orderDescription);
        String username = principal.getName();
        User user = clientService.getClientByUsername(username);
        orderDomain.setDomainOrderUserId(user.getIdUser());
        orderDomain.setDomainOrderStatus("Pendiente");
        orderDomain.setDomainOrderPaymentId(orderPaymentId);

        OrderDomain createdOrder = orderService.createOrder(orderDomain);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDomain> getOrderById(@PathVariable int orderId) {
        Optional<OrderDomain> order = orderService.getOrderById(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int orderId) {
        boolean deleted = orderService.deleteOrder(orderId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<Void> updateOrderStatus(
            @RequestParam("orderId") int orderId,
            @RequestParam("status") String status) {
        orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok().build();
    }
}