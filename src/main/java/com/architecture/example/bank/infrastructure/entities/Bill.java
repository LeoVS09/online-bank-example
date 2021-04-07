package com.architecture.example.bank.infrastructure.entities;

import javax.persistence.*;

@Entity
@Table(name = "Bank_Bill")
public class Bill implements com.architecture.example.bank.data.Bill {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Seller_id")
    private Long sellerId;

    @Column(name = "Customer_id")
    private Long customerId;

    @Column(name = "Amount")
    private double amount;

    public Long getSellerId() {
        return sellerId;
    }

    @Override
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    @Override
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
