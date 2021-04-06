package com.architecture.example.bank.presenter;

import com.architecture.example.bank.logic.TransactionException;
import com.architecture.example.bank.logic.TransactionService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
public class ApiController {

    private TransactionService transactionService;

    public ApiController(EntityManager entityManager) {
        this.transactionService = new TransactionService(entityManager);
    }

    @GetMapping("/send-money/{to}/{amount}")
    public Double sendMoney(@RequestHeader("x-user-id") Long from, @PathVariable Long to, @PathVariable double amount) throws TransactionException {
        return this.transactionService.sendMoney(from, to, amount);
    }
}
