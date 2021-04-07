package com.architecture.example.bank.boundaries;

import com.architecture.example.bank.entity.TransactionException;
import com.architecture.example.bank.interactors.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/send-money/{to}/{amount}")
    public Double sendMoney(@RequestHeader("x-user-id") Long from, @PathVariable Long to, @PathVariable double amount) throws TransactionException {
        return this.transactionService.sendMoney(from, to, amount);
    }

    @PostMapping("/transfer-between")
    public Double transferBetween(@RequestBody TransferRequest request) throws TransactionException {
        return this.transactionService.sendMoney(request.getFrom(), request.getTo(), request.getAmount());
    }
}
