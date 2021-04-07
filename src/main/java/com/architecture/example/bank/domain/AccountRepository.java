package com.architecture.example.bank.domain;

import javax.persistence.EntityTransaction;

public interface AccountRepository {

    Account findById(Long id);

    EntityTransaction getTransaction();
}
