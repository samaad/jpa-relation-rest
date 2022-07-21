package org.learning.jparelationrest.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.learning.jparelationrest.modal.entity.user.Payment;
import org.learning.jparelationrest.modal.entity.user.User;
import org.learning.jparelationrest.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        User user = payment.getUser();
        payment.setUser(user);
        return paymentRepository.save(payment);
    }

    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to find the payment"));
    }

    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }
}
