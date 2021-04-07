package com.architecture.example.bank.application;

import com.architecture.example.bank.domain.Account;

import javax.persistence.EntityTransaction;

public interface UserRepository {

    User findById(Long id);

    EntityTransaction getTransaction();
}
