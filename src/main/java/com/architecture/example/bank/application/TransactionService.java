package com.architecture.example.bank.application;

import com.architecture.example.bank.domain.Account;
import com.architecture.example.bank.domain.TransactionException;
import com.architecture.example.bank.services.TransferService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;

@Service
public class TransactionService {

    private UserRepository accountRepository;

    private TransferService transferService;

    public TransactionService(UserRepository accountRepository, TransferService transferService) {
        this.accountRepository = accountRepository;
        this.transferService = transferService;
    }

    public double sendMoney(Long from, Long to, double amount) throws TransactionException {
        EntityTransaction transaction = null;

        try {
            User source = this.accountRepository.findById(from);
            User target = this.accountRepository.findById(to);

            transaction = this.accountRepository.getTransaction();
            transaction.begin();

            double result = this.transferService.transferMoney(source, target, amount);

            transaction.commit();

            return result;

        } catch (Throwable e) {
            if( transaction != null) {
                transaction.rollback();
            }
            throw e;
        }

    }
}
