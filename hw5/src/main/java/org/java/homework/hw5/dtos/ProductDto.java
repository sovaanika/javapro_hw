package org.java.homework.hw5.dtos;

import org.java.homework.hw5.entities.ProductEntity;

public class ProductDto {
    private Long productId;
    private Long accountNumber;
    private Long balance;
    private ProductEntity.ProductType productType;

    public ProductDto(Long productId, Long accountNumber, Long balance, ProductEntity.ProductType productType) {
        this.productId = productId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = productType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public ProductEntity.ProductType getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = ProductEntity.ProductType.valueOf(productType);
    }
}
