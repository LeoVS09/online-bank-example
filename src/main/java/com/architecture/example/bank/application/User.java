package com.architecture.example.bank.application;

import com.architecture.example.bank.domain.Account;

public abstract class User extends Account {

    public abstract String getName();

    public abstract void setName(String name);
}
