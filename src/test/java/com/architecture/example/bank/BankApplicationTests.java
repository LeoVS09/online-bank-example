package com.architecture.example.bank;

import com.architecture.example.bank.application.User;
import com.architecture.example.bank.domain.Account;
import com.architecture.example.bank.application.UserRepository;
import com.architecture.example.bank.domain.TransactionException;
import com.architecture.example.bank.application.TransactionService;
import com.architecture.example.bank.services.TransferService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityTransaction;
import java.util.HashMap;

@SpringBootTest
class BankApplicationTests {

    @Test
    void sendMoneyWork() throws TransactionException {
        UserRepository repository = new UserMockRepository();
        TransactionService service = new TransactionService(repository, new TransferService());

        Long sourceId = 1L;
        Long targetId = 2L;

        service.sendMoney(sourceId, targetId, 200);

        Assertions.assertEquals(repository.findById(sourceId).getBalance(), 800);
        Assertions.assertEquals(repository.findById(targetId).getBalance(), 1200);
    }

    private class UserMockRepository implements UserRepository {

        private HashMap<Long, UserMock> map = new HashMap<Long, UserMock>();

        public UserMockRepository(){
            this.map.put(1L, new UserMock(1000));
            this.map.put(2L, new UserMock(1000));
        }

        @Override
        public User findById(Long id) {
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

        private class UserMock extends User {

            private double balance;
            private String name;

            public UserMock(double balance) {
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

            @Override
            public String getName() {
                return this.name;
            }

            @Override
            public void setName(String name) {
                this.name = name;
            }
        }
    }

}


