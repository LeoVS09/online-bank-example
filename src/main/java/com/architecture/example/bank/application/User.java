package com.architecture.example.bank.application;

import com.architecture.example.bank.domain.Account;

public abstract class User {

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Account getAccount();
}
