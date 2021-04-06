package com.architecture.example.bank;

import com.architecture.example.bank.infrastructure.UserRepository;
import com.architecture.example.bank.logic.TransactionException;
import com.architecture.example.bank.logic.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankApplicationTests {

    @Test
    void sendMoneyWork() throws TransactionException {
        TransactionService service = new TransactionService();
        UserRepository repository = service.getUserRepository();

        Long sourceId = 1L;
        Long targetId = 2L;

        repository.findById(sourceId).getAccount().setBalance(1000);
        repository.findById(targetId).getAccount().setBalance(1000);

        service.sendMoney(sourceId, targetId, 200);

        Assertions.assertEquals(repository.findById(sourceId).getAccount().getBalance(), 800);
        Assertions.assertEquals(repository.findById(targetId).getAccount().getBalance(), 1200);
    }

}
