package com.architecture.example.bank.infrastructure.entities;

import javax.persistence.*;

@Entity
@Table(name = "Bank_User")
public class User implements com.architecture.example.bank.data.User {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Name", length = 128, nullable = false)
    private String name;

    @Column(name = "Balance", nullable = false)
    private double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
