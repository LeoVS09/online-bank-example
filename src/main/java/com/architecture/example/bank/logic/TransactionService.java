package com.architecture.example.bank.logic;

import com.architecture.example.bank.infrastructure.UserRepository;
import com.architecture.example.bank.infrastructure.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TransactionService {

    private UserRepository userRepository;

    public TransactionService(){
        this.userRepository = new UserRepository();
    }

    public double sendMoney(Long from, Long to, double amount) throws TransactionException {
        EntityTransaction transaction = null;

        try {
            User source = this.userRepository.findById(from);
            User target = this.userRepository.findById(to);

            double newSourceBalance = source.getBalance() - amount;
            if (newSourceBalance < 0 ) {
                throw new TransactionException("Not enough money");
            }

            double newDestinationBalance = target.getBalance() + amount;

            transaction = this.userRepository.getTransaction();
            transaction.begin();

            source.setBalance(newSourceBalance);
            target.setBalance(newDestinationBalance);

            transaction.commit();

            return newSourceBalance;

        } catch (Throwable e) {
            if( transaction != null) {
                transaction.rollback();
            }
            throw e;
        }

    }
}