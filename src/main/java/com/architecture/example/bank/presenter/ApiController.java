package com.architecture.example.bank.presenter;

import com.architecture.example.bank.contexts.transfer.TransferContext;
import com.architecture.example.bank.domain.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    private TransferContext transferContext;

    @GetMapping("/send-money/{to}/{amount}")
    public Double sendMoney(@RequestHeader("x-user-id") Long from, @PathVariable Long to, @PathVariable double amount) throws TransactionException {
        return this.transferContext.sendMoney(from, to, amount);
    }

    @PostMapping("/transfer-between")
    public Double transferBetween(@RequestBody TransferRequest request) throws TransactionException {
        return this.transferContext.sendMoney(request.getFrom(), request.getTo(), request.getAmount());
    }
}
