package com.shopease.Inputs;

import com.shopease.Entities.OrderItem;
import com.shopease.Entities.CartItem;
import com.shopease.Services.CartItemService;

import java.util.Scanner;

public class OrderItemInput {

    private final CartItemService cartItemService;
    private final Scanner scanner = new Scanner(System.in);

    public OrderItemInput(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    public OrderItem getOrderItemInput() {
        System.out.print("Enter CartItem ID: ");
        Long cartItemId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        CartItem cartItem = cartItemService.getCartItemById(cartItemId);

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        OrderItem orderItem = new OrderItem();
        orderItem.setCartItem(cartItem);
        orderItem.setQuantity(quantity);

        return orderItem;
    }
}
