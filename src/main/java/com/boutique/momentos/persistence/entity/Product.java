package com.boutique.momentos.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int productId;
    
    @Column(name = "nombre")
    private String productName;
    
    @Column(name = "descripcion")
    private String productDescription;
    
    @Column(name = "precio")
    private float productPrice;
    
    @Column(name = "stock")
    private int productStock;
    
    @Column(name = "id_categoria")
    private int productCategoryId;
    
    @Column(name = "id_usuario")
    private int productUserId;
    
    @Column(name = "imagen")
    private byte[] productImageData;
    
    @Column(name = "status")
    private boolean productStatus;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Order order;

    @OneToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Category category;

    @OneToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private User user;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public int getProductUserId() {
        return productUserId;
    }

    public void setProductUserId(int productUserId) {
        this.productUserId = productUserId;
    }

    public byte[] getProductImageData() {
        return productImageData;
    }

    public void setProductImageData(byte[] productImageData) {
        this.productImageData = productImageData;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}