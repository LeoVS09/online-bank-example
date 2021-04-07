package com.architecture.example.bank.contexts.bill;

import com.architecture.example.bank.infrastructure.BillRepository;
import com.architecture.example.bank.infrastructure.UserRepository;
import com.architecture.example.bank.infrastructure.entities.Bill;
import org.springframework.stereotype.Service;

@Service
public class BillContext {

    private UserRepository userRepository;
    private BillRepository billRepository;

    public BillContext(UserRepository userRepository, BillRepository billRepository) {
        this.userRepository = userRepository;
        this.billRepository = billRepository;
    }

    public void makeBill(Long customerId, Long sellerId, double amount) {
        SellerRole seller = new SellerRole(this.userRepository.findById(sellerId));
        CustomerRole customer = new CustomerRole(this.userRepository.findById(customerId));

        Bill bill = new Bill();
        seller.makeBill(customer, amount, bill);

        this.billRepository.save(bill);
    }
}
