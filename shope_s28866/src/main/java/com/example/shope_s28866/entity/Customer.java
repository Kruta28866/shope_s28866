package com.example.shope_s28866.entity;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Customer {
    private int id;
    private double balance;

    public Customer(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }
}
