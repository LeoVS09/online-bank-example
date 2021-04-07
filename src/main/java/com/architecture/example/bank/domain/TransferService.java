package com.architecture.example.bank.domain;

import com.architecture.example.bank.infrastructure.UserRepository;
import com.architecture.example.bank.infrastructure.entities.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;

@Service
public class TransferService {

    private AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public double sendMoney(Long from, Long to, double amount) throws TransactionException {
        EntityTransaction transaction = null;

        try {
            Account source = this.accountRepository.findById(from);
            Account target = this.accountRepository.findById(to);

            transaction = this.accountRepository.getTransaction();
            transaction.begin();

            source.credit(amount);
            target.debit(amount);

            transaction.commit();

            return target.getBalance();

        } catch (Throwable e) {
            if( transaction != null) {
                transaction.rollback();
            }
            throw e;
        }

    }
}
