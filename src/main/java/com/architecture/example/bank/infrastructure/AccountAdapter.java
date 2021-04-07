package com.architecture.example.bank.infrastructure;

import com.architecture.example.bank.domain.Account;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;

@Service
public class AccountAdapter implements com.architecture.example.bank.application.AccountRepository {

    private UserRepository userRepository;

    public AccountAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Account findById(Long id) {
        return this.userRepository.findById(id).getAccount();
    }

    @Override
    public EntityTransaction getTransaction() {
        return this.userRepository.getTransaction();
    }
}
