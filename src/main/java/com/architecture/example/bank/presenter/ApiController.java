package com.architecture.example.bank.presenter;

import com.architecture.example.bank.logic.TransactionException;
import com.architecture.example.bank.logic.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    private TransactionService transactionService;

    public ApiController() {
        this.transactionService = new TransactionService();
    }

    @GetMapping("/send-money/{to}/{amount}")
    public Double sendMoney(@RequestHeader("x-user-id") Long from, @PathVariable Long to, @PathVariable double amount) throws TransactionException {
        return this.transactionService.sendMoney(from, to, amount);
    }

    @PostMapping("/transfer-between")
    public Double transferBetween(@RequestBody TransferRequest request) throws TransactionException {
        return this.transactionService.sendMoney(request.getFrom(), request.getTo(), request.getAmount());
    }
}
