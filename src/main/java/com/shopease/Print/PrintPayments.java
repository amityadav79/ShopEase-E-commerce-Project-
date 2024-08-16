package com.shopease.Print;

import com.shopease.Entities.Payment;

import java.util.List;

public class PrintPayments {

    public void print(List<Payment> payments) {
        for (Payment payment : payments) {
            System.out.println("Payment ID: " + payment.getId());
            System.out.println("Method: " + payment.getPaymentMethod());
//            System.out.println("Description: " + payment.getDescription());
            System.out.println("----------------------");
        }
    }
}
