package com.architecture.example.bank.data;

public interface Bill {
    public void setSellerId(Long seller) ;
    public void setCustomerId(Long customer);
    public void setAmount(double amount);
}
