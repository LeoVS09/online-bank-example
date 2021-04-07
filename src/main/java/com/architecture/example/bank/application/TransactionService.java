package com.architecture.example.bank.application;

import com.architecture.example.bank.domain.Account;
import com.architecture.example.bank.domain.TransactionException;
import com.architecture.example.bank.services.TransferService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;

@Service
public class TransactionService {

    private UserRepository userRepository;

    private TransferService transferService;

    public TransactionService(UserRepository userRepository, TransferService transferService) {
        this.userRepository = userRepository;
        this.transferService = transferService;
    }

    public double sendMoney(Long from, Long to, double amount) throws TransactionException {
        EntityTransaction transaction = null;

        try {
            User source = this.userRepository.findById(from);
            User target = this.userRepository.findById(to);

            transaction = this.userRepository.getTransaction();
            transaction.begin();

            double result = this.transferService.transferMoney(source.getAccount(), target.getAccount(), amount);

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
