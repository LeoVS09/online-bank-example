package com.architecture.example.bank.interactors;

import com.architecture.example.bank.entity.Account;
import com.architecture.example.bank.entity.TransactionException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;

@Service
public class TransactionService {

    private AccountRepository accountRepository;

    public TransactionService(AccountRepository accountRepository) {
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

            return source.getBalance();

        } catch (Throwable e) {
            if( transaction != null) {
                transaction.rollback();
            }
            throw e;
        }

    }
}
