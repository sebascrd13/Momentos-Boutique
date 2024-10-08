package com.boutique.momentos.domain.domainentity;

public class OrderDomain {
    private int domainOrderId;
    private String domainOrderLocation;
    private int domainOrderUserId;
    private String domainOrderStatus;
    private int domainOrderPaymentId;
    private String domainOrderDescription;

    public int getDomainOrderId() {
        return domainOrderId;
    }
    public void setDomainOrderId(int domainOrderId) {
        this.domainOrderId = domainOrderId;
    }
    public String getDomainOrderLocation() {
        return domainOrderLocation;
    }
    public void setDomainOrderLocation(String domainOrderLocation) {
        this.domainOrderLocation = domainOrderLocation;
    }
    public int getDomainOrderUserId() {
        return domainOrderUserId;
    }
    public void setDomainOrderUserId(int domainOrderUserId) {
        this.domainOrderUserId = domainOrderUserId;
    }
    public String getDomainOrderStatus() {
        return domainOrderStatus;
    }
    public void setDomainOrderStatus(String domainOrderStatus) {
        this.domainOrderStatus = domainOrderStatus;
    }
    public int getDomainOrderPaymentId() {
        return domainOrderPaymentId;
    }
    public void setDomainOrderPaymentId(int domainOrderPaymentId) {
        this.domainOrderPaymentId = domainOrderPaymentId;
    }
    public String getDomainOrderDescription() {
        return domainOrderDescription;
    }
    public void setDomainOrderDescription(String domainOrderDescription) {
        this.domainOrderDescription = domainOrderDescription;
    }
}
