package com.shopease.Inputs;

import com.shopease.Entities.Payment;
import com.shopease.Entities.OrderItem;
import com.shopease.Services.OrderItemService;

import java.util.Scanner;

public class PaymentInput {

    private final OrderItemService orderItemService;
    private final Scanner scanner = new Scanner(System.in);

    public PaymentInput(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    public Payment getPaymentInput() {
        System.out.print("Enter OrderItem ID: ");
        Long orderItemId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        OrderItem orderItem = orderItemService.getOrderItemById(orderItemId);

        System.out.print("Enter Payment Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Payment payment = new Payment();
        payment.setOrderItem(orderItem);
        payment.setAmount(amount);

        return payment;
    }
}
