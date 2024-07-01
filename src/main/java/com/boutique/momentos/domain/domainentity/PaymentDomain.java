package com.boutique.momentos.domain.domainentity;

import java.time.LocalDateTime;

public class PaymentDomain {
    private int domainIdPayment;
    private int domainIdUser;
    private byte[] domainImageData;
    private LocalDateTime domainPaymentDate;
    private boolean domainPaymentStatus;

    public int getDomainIdPayment() {
        return domainIdPayment;
    }
    public void setDomainIdPayment(int domainIdPayment) {
        this.domainIdPayment = domainIdPayment;
    }
    public int getDomainIdUser() {
        return domainIdUser;
    }
    public void setDomainIdUser(int domainIdUser) {
        this.domainIdUser = domainIdUser;
    }
    public byte[] getDomainImageData() {
        return domainImageData;
    }
    public void setDomainImageData(byte[] domainImageData) {
        this.domainImageData = domainImageData;
    }
    public boolean isDomainPaymentStatus() {
        return domainPaymentStatus;
    }
    public void setDomainPaymentStatus(boolean domainPaymentStatus) {
        this.domainPaymentStatus = domainPaymentStatus;
    }
    public LocalDateTime getDomainPaymentDate() {
        return domainPaymentDate;
    }
    public void setDomainPaymentDate(LocalDateTime domainPaymentDate) {
        this.domainPaymentDate = domainPaymentDate;
    }
}
