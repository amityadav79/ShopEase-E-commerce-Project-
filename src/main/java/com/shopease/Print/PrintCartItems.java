package com.shopease.Print;

import com.shopease.Entities.CartItem;
import java.util.List;

public class PrintCartItems {

    public void print(List<CartItem> cartItems) {
        if (cartItems.isEmpty()) {
            System.out.println("No Cart Items found.");
            return;
        }

        for (CartItem cartItem : cartItems) {
            System.out.println("Cart Item ID: " + cartItem.getId());
            System.out.println("Product: " + cartItem.getProduct().getName());
            System.out.println("User: " + cartItem.getUser().getUsername());
            System.out.println("Quantity: " + cartItem.getQuantity());
            System.out.println("------------------------");
        }
    }
}
