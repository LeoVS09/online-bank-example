package com.architecture.example.bank.contexts.transfer;

import com.architecture.example.bank.domain.TransactionException;
import com.architecture.example.bank.infrastructure.entities.User;

public class SourceAccountRole {
    private User user;


    public SourceAccountRole(User user) {
        this.user = user;
    }

    public double transferTo(DestinationAccountRole target, double amount) throws TransactionException {
        this.credit(amount);
        target.debit(amount);

        return this.user.getBalance();
    }

    private void credit(double amount) throws TransactionException {
        double newBalance = this.user.getBalance() - amount;
        if(newBalance < 0) {
            throw new TransactionException("Not enough money for credit account");
        }

        this.user.setBalance(newBalance);
    }

}
