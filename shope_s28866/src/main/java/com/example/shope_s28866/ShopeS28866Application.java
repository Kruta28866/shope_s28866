package com.example.shope_s28866;

import com.example.shope_s28866.entity.Cart;
import com.example.shope_s28866.entity.Customer;
import com.example.shope_s28866.entity.Item;
import com.example.shope_s28866.service.ShopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShopeS28866Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShopeS28866Application.class, args);
		ShopService shopService = context.getBean(ShopService.class);

		Customer customer = new Customer(1, 150);
		Cart cart = new Cart(customer);

		Item milk = new Item("milk", 2.50);
		Item beer = new Item("beer", 5.50);

		cart.addItem(milk);
		cart.addItem(beer);
		cart.addItem(milk);

		boolean cashout = shopService.cashCart(cart);

		if(cashout){
			System.out.println("Success!");
		}
		else{
			System.out.println("Failed!");
		}
	}

}
