package com.example.shope_s28866.repository;

import com.example.shope_s28866.entity.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Storage {

    private Map<String, Double> items;

    public Storage() {
        items = new HashMap<>();
        items.put("milk", 2.00);
        items.put("beer", 5.00);
    }

    public Double getItemPrice(String item){
        return items.get(item);
    }
}
