package com.architecture.example.bank.contexts.bill;

import com.architecture.example.bank.data.Bill;
import com.architecture.example.bank.data.User;

public class SellerRole {
    private User user;

    public SellerRole(User user) {
        this.user = user;
    }

    public void makeBill(CustomerRole customer, double amount, Bill blank) {
        blank.setSellerId(this.user.getId());
        blank.setCustomerId(customer.getId());
        blank.setAmount(amount);
    }
}
