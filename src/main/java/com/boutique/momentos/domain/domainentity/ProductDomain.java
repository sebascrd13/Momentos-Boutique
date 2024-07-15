package com.boutique.momentos.domain.domainentity;

public class ProductDomain {
    private int domainProductId;
    private String domainProductName;
    private String domainProductDescription;
    private float domainProductPrice;
    private int domainProductStock;
    private int domainProductCategoryId;
    private int domainProductUserId;
    private String domainProductImagePath;
    private char domainProductSize;
    private boolean domainProductStatus;

    public int getDomainProductId() {
        return domainProductId;
    }
    public void setDomainProductId(int domainProductId) {
        this.domainProductId = domainProductId;
    }
    public String getDomainProductName() {
        return domainProductName;
    }
    public void setDomainProductName(String domainProductName) {
        this.domainProductName = domainProductName;
    }
    public String getDomainProductDescription() {
        return domainProductDescription;
    }
    public void setDomainProductDescription(String domainProductDescription) {
        this.domainProductDescription = domainProductDescription;
    }
    public float getDomainProductPrice() {
        return domainProductPrice;
    }
    public void setDomainProductPrice(float domainProductPrice) {
        this.domainProductPrice = domainProductPrice;
    }
    public int getDomainProductStock() {
        return domainProductStock;
    }
    public void setDomainProductStock(int domainProductStock) {
        this.domainProductStock = domainProductStock;
    }
    public int getDomainProductCategoryId() {
        return domainProductCategoryId;
    }
    public void setDomainProductCategoryId(int domainProductCategoryId) {
        this.domainProductCategoryId = domainProductCategoryId;
    }
    public int getDomainProductUserId() {
        return domainProductUserId;
    }
    public void setDomainProductUserId(int domainProductUserId) {
        this.domainProductUserId = domainProductUserId;
    }
    public String getDomainProductImagePath() {
        return domainProductImagePath;
    }
    public void setDomainProductImagePath(String domainProductImagePath) {
        this.domainProductImagePath = domainProductImagePath;
    }
    public char getDomainProductSize() {
        return domainProductSize;
    }
    public void setDomainProductSize(char domainProductSize) {
        this.domainProductSize = domainProductSize;
    }
    public boolean isDomainProductStatus() {
        return domainProductStatus;
    }
    public void setDomainProductStatus(boolean domainProductStatus) {
        this.domainProductStatus = domainProductStatus;
    }
}
