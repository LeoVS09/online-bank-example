package com.architecture.example.bank.services;

import com.architecture.example.bank.domain.Account;
import com.architecture.example.bank.domain.TransactionException;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    public double transferMoney(Account source, Account target, double amount) throws TransactionException {
        source.credit(amount);
        target.debit(amount);

        return source.getBalance();
    }
}
