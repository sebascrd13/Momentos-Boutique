package com.boutique.momentos.domain.domainentity;

public class OrderDomain {
    private int domainOrderId;
    private String domainOrderPaymentMethod;
    private String domainOrderLocation;
    private float domainOrderCost;
    private int domainOrderProductId;
    private int domainOrderUserId;
    private boolean domainOrderStatus;

    public int getDomainOrderId() {
        return domainOrderId;
    }
    public void setDomainOrderId(int domainOrderId) {
        this.domainOrderId = domainOrderId;
    }
    public String getDomainOrderPaymentMethod() {
        return domainOrderPaymentMethod;
    }
    public void setDomainOrderPaymentMethod(String domainOrderPaymentMethod) {
        this.domainOrderPaymentMethod = domainOrderPaymentMethod;
    }
    public String getDomainOrderLocation() {
        return domainOrderLocation;
    }
    public void setDomainOrderLocation(String domainOrderLocation) {
        this.domainOrderLocation = domainOrderLocation;
    }
    public float getDomainOrderCost() {
        return domainOrderCost;
    }
    public void setDomainOrderCost(float domainOrderCost) {
        this.domainOrderCost = domainOrderCost;
    }
    public int getDomainOrderProductId() {
        return domainOrderProductId;
    }
    public void setDomainOrderProductId(int domainOrderProductId) {
        this.domainOrderProductId = domainOrderProductId;
    }
    public int getDomainOrderUserId() {
        return domainOrderUserId;
    }
    public void setDomainOrderUserId(int domainOrderUserId) {
        this.domainOrderUserId = domainOrderUserId;
    }
    public boolean isDomainOrderStatus() {
        return domainOrderStatus;
    }
    public void setDomainOrderStatus(boolean domainOrderStatus) {
        this.domainOrderStatus = domainOrderStatus;
    }
}
