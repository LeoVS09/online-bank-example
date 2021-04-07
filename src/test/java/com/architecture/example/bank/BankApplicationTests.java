package com.architecture.example.bank;

import com.architecture.example.bank.interactors.AccountRepository;
import com.architecture.example.bank.entity.Account;
import com.architecture.example.bank.entity.TransactionException;
import com.architecture.example.bank.interactors.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityTransaction;
import java.util.HashMap;

@SpringBootTest
class BankApplicationTests {

    @Test
    void sendMoneyWork() throws TransactionException {
        AccountRepository repository = new UserMockRepository();
        TransactionService service = new TransactionService(repository);

        Long sourceId = 1L;
        Long targetId = 2L;

        service.sendMoney(sourceId, targetId, 200);

        Assertions.assertEquals(repository.findById(sourceId).getBalance(), 800);
        Assertions.assertEquals(repository.findById(targetId).getBalance(), 1200);
    }

    private class UserMockRepository implements AccountRepository {

        private HashMap<Long, Account> map = new HashMap<Long, Account>();

        public UserMockRepository(){
            this.map.put(1L, new AccountMock(1000));
            this.map.put(2L, new AccountMock(1000));
        }

        @Override
        public Account findById(Long id) {
            return this.map.get(id);
        }

        @Override
        public EntityTransaction getTransaction() {
            return new EntityTransaction() {
                @Override
                public void begin() {}

                @Override
                public void commit() {}

                @Override
                public void rollback() {}

                @Override
                public void setRollbackOnly() {}

                @Override
                public boolean getRollbackOnly() {
                    return false;
                }

                @Override
                public boolean isActive() {
                    return false;
                }
            };
        }

        private class AccountMock extends Account {

            private double balance;

            public AccountMock(double balance) {
                this.balance = balance;
            }

            @Override
            public double getBalance() {
                return this.balance;
            }

            @Override
            public void setBalance(double amount) {
                this.balance = amount;
            }
        }
    }

}


