package com.architecture.example.bank.infrastructure;

import com.architecture.example.bank.infrastructure.entities.Bill;
import com.architecture.example.bank.infrastructure.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class BillRepository {

    private EntityManager entityManager;

    public BillRepository(EntityManager entityManager) {
        this.entityManager = entityManager.getEntityManagerFactory().createEntityManager();
    }

    public void save(Bill bill) {
        this.entityManager.persist(bill);
    }

}
