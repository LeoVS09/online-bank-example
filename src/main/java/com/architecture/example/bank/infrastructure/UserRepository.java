package com.architecture.example.bank.infrastructure;

import com.architecture.example.bank.infrastructure.entities.User;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;

public class UserRepository  {

    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        // Create repository specific entity manager
        this.entityManager = entityManager.getEntityManagerFactory().createEntityManager();
    }

    public User findById(Long id) {
        return this.entityManager.find(User.class, id);
    }

    public EntityTransaction getTransaction() {
        return this.entityManager.getTransaction();
    }

}
