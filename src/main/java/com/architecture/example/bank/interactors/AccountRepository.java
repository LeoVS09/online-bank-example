package com.architecture.example.bank.interactors;

import com.architecture.example.bank.entity.Account;

import javax.persistence.EntityTransaction;

public interface AccountRepository {

    Account findById(Long id);

    EntityTransaction getTransaction();
}
