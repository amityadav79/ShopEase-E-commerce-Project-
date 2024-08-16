package com.shopease.dao;

import com.shopease.Entities.Payment;
import java.util.List;

public interface PaymentDAO {
    void savePayment(Payment payment);
    Payment getPaymentById(Long id);
    List<Payment> getPaymentsByUserId(Long userId);
    List<Payment> getPaymentsByOrderId(Long orderId);
    List<Payment> getAllPayments();  // Missing method added
    void deletePayment(Long id);
}
