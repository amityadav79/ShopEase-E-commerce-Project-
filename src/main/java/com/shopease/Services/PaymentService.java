package com.shopease.Services;

import com.shopease.Entities.Payment;
import java.util.List;

public interface PaymentService {
    void savePayment(Payment payment);
    Payment getPaymentById(Long id);
    List<Payment> getAllPayments();
    void deletePayment(Long id);
}
