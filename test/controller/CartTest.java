package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void addToCart() {
        Cart cart = new Cart();
        Product product = new Product(1,"fiets", 50.00, 1);
        cart.addToCart(product);
        assertEquals(product.getName(),"fiets");
    }
}