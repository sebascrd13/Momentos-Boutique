package com.boutique.momentos.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_productos")
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "id_pedido")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "id_producto")
    private Product product;

    @Column(name = "cantidad")
    private int quantity;

    public OrderProductId getId() {
        return id;
    }

    public void setId(OrderProductId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}