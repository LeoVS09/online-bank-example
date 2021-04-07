package com.architecture.example.bank.contexts.transfer;


import com.architecture.example.bank.data.User;

public class DestinationAccountRole {

    private User user;


    public DestinationAccountRole(User user) {
        this.user = user;
    }

    // increase balance
    public void debit(double amount) {
        this.user.setBalance(this.user.getBalance() + amount);
    }
}
