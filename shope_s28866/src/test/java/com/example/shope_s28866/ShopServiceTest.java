package com.example.shope_s28866;

import com.example.shope_s28866.entity.Cart;
import com.example.shope_s28866.entity.Customer;
import com.example.shope_s28866.entity.Item;
import com.example.shope_s28866.repository.Storage;
import com.example.shope_s28866.service.ShopService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class ShopServiceTest {
    @Mock
    private Storage storage;

    @InjectMocks
    private ShopService shopService;

    private Customer customer;

    private Cart cart;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        customer = new Customer(150, 50);
        cart = new Cart(this.customer);
    }

    @Test
    public void checkIfCustomerCanBuyProductsShouldReturnTrue(){
        when(storage.getItemPrice("milk")).thenReturn(2.5);
        when(storage.getItemPrice("beer")).thenReturn(5.5);

        Item milk = new Item("milk", 2.5);
        Item beer = new Item("beer", 5.5);

        cart.addItem(milk);
        cart.addItem(beer);
        cart.addItem(beer);

        boolean result = shopService.cashCart(cart);

        System.out.println(customer.getBalance());
        Assertions.assertTrue(result);
    }
}
