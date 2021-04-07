package com.architecture.example.bank.contexts.transfer;

import com.architecture.example.bank.domain.TransactionException;
import com.architecture.example.bank.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;

@Service
public class TransferContext {
    private UserRepository userRepository;

    public TransferContext(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public double sendMoney(Long from, Long to, double amount) throws TransactionException {
        EntityTransaction transaction = null;

        try {
            SourceAccountRole source = new SourceAccountRole(this.userRepository.findById(from));
            DestinationAccountRole target = new DestinationAccountRole(this.userRepository.findById(to));

            transaction = this.userRepository.getTransaction();
            transaction.begin();

            double result = source.transferTo(target, amount);

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
