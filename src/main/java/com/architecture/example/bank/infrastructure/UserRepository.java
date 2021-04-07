package com.architecture.example.bank.infrastructure;

import com.architecture.example.bank.application.AccountRepository;
import com.architecture.example.bank.infrastructure.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class UserRepository implements AccountRepository {

    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager.getEntityManagerFactory().createEntityManager();
    }

    public User findById(Long id) {
        return this.entityManager.find(User.class, id);
    }

    public EntityTransaction getTransaction() {
        return this.entityManager.getTransaction();
    }

}
