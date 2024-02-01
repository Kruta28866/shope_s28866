package com.example.shope_s28866.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cart {
    private Long id;
    private Customer customer;
    private List<Item> items;

    public Cart(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }
}
