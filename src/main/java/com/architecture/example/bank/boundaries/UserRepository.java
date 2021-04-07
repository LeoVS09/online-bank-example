package com.architecture.example.bank.boundaries;

import com.architecture.example.bank.interactors.AccountRepository;
import com.architecture.example.bank.boundaries.entities.User;
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
