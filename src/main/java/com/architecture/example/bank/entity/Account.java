package com.architecture.example.bank.entity;

public abstract class Account {

    abstract public double getBalance();
    abstract public void setBalance(double amount);

    // increase balance
    public void debit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }

    public void credit(double amount) throws TransactionException {
        double newBalance = this.getBalance() - amount;
        if(newBalance < 0) {
            throw new TransactionException("Not enough money for credit account");
        }

        this.setBalance(newBalance);
    }

}
