package com.architecture.example.bank.infrastructure;

import com.architecture.example.bank.infrastructure.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserRepository  {

    private EntityManager entityManager;

    public UserRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "postgres" );
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public User findById(Long id) {
        return this.entityManager.find(User.class, id);
    }

    public EntityTransaction getTransaction() {
        return this.entityManager.getTransaction();
    }

}
