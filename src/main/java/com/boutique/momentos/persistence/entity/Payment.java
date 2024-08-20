package com.boutique.momentos.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagos")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private int idPayment;
    @Column(name = "id_usuario")
    private int idUser;
    @Column(name = "imagen")
    private String imageData;
    @Column(name = "fecha")
    private LocalDateTime paymentDate;
    @Column(name = "estado")
    private boolean paymentStatus;
    @Column(name = "metodo_pago")
    private String paymentMethod;
    @Column(name = "costo_total_pago")
    private int paymentTotalCost;

    @OneToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private User user;

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentTotalCost() {
        return paymentTotalCost;
    }

    public void setPaymentTotalCost(int paymentTotalCost) {
        this.paymentTotalCost = paymentTotalCost;
    }
}
