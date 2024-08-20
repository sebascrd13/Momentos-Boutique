package com.boutique.momentos.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private int cartId;
    @Column(name = "id_usuario")
    private int cartUserId;
    @Column(name = "id_producto")
    private int cartProductId;
    @Column(name = "cantidad")
    private int cartProductQuantity;

    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    public int getCartUserId() {
        return cartUserId;
    }
    public void setCartUserId(int cartUserId) {
        this.cartUserId = cartUserId;
    }
    public int getCartProductId() {
        return cartProductId;
    }
    public void setCartProductId(int cartProductId) {
        this.cartProductId = cartProductId;
    }
    public int getCartProductQuantity() {
        return cartProductQuantity;
    }
    public void setCartProductQuantity(int cartProductQuantity) {
        this.cartProductQuantity = cartProductQuantity;
    }
}
