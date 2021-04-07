package com.architecture.example.bank.data;

import com.architecture.example.bank.domain.TransactionException;

public abstract class User {

    abstract public double getBalance();
    abstract public void setBalance(double amount);

    // increase balance
    public void debit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }



}
