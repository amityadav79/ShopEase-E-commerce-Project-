package com.shopease.ServicesImpl;

import com.shopease.dao.PaymentDAO;
import com.shopease.Entities.Payment;
import com.shopease.Services.PaymentService;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private PaymentDAO paymentDAO;

    public PaymentServiceImpl() {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public void savePayment(Payment payment) {
        paymentDAO.savePayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentDAO.getAllPayments();
    }

    @Override
    public void deletePayment(Long id) {
        paymentDAO.deletePayment(id);
    }
}
