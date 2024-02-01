package com.example.shope_s28866.service;

import com.example.shope_s28866.entity.Cart;
import com.example.shope_s28866.entity.Item;
import com.example.shope_s28866.repository.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    private final Storage storage;

    @Autowired
    public ShopService(Storage storage) {
        this.storage = storage;
    }

    public boolean cashCart(Cart cart){
        double totalCost = 0;
        for (Item item : cart.getItems()){
            Double price = storage.getItemPrice(item.getName());
            if(price != null){
                totalCost += price;
            }
        }

        if(cart.getCustomer().getBalance() >= totalCost){
            cart.getCustomer().setBalance(cart.getCustomer().getBalance() - totalCost);
            return true;
        }
        else{
            return false;
        }
    }
}
