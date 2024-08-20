package com.boutique.momentos.domain.domainentity;

public class CartDomain {
    private int domainCartId;
    private int domainCartUserId;
    private int domainCartProductId;
    private int domainCartProductQuantity;

    public int getDomainCartId() {
        return domainCartId;
    }
    public void setDomainCartId(int domainCartId) {
        this.domainCartId = domainCartId;
    }
    public int getDomainCartUserId() {
        return domainCartUserId;
    }
    public void setDomainCartUserId(int domainCartUserId) {
        this.domainCartUserId = domainCartUserId;
    }
    public int getDomainCartProductId() {
        return domainCartProductId;
    }
    public void setDomainCartProductId(int domainCartProductId) {
        this.domainCartProductId = domainCartProductId;
    }
    public int getDomainCartProductQuantity() {
        return domainCartProductQuantity;
    }
    public void setDomainCartProductQuantity(int domainCartProductQuantity) {
        this.domainCartProductQuantity = domainCartProductQuantity;
    }
}
