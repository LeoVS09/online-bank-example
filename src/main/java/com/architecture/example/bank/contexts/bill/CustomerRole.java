package com.architecture.example.bank.contexts.bill;

import com.architecture.example.bank.data.User;

public class CustomerRole {
    private User user;

    public CustomerRole(User user) {
        this.user = user;
    }

    public Long getId(){
        return this.user.getId();
    }
}
