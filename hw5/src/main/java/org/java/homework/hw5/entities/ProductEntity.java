package org.java.homework.hw5.entities;

public class ProductEntity {
    ProductType productType;
    private Long productId;
    private Long accountNumber;
    private Long balance;

    public ProductEntity(Long productId, Long accountNumber, Long balance, ProductType productType) {
        this.productId = productId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = productType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + productId +
                ", accountNumber=" + accountNumber +
                ", productType='" + productType + '\'' +
                ", balance=" + balance +
                '}';
    }

    public enum ProductType {
        card,
        account;
    }
}
