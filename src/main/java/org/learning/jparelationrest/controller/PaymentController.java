package org.learning.jparelationrest.controller;

import java.util.List;
import org.learning.jparelationrest.modal.entity.user.Payment;
import org.learning.jparelationrest.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping
    @ResponseBody
    public Payment saveOrder(@RequestBody Payment payment) {
        Payment saveOrder = paymentService.createPayment(payment);
        return saveOrder;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Payment getOrderById(@PathVariable Long id) {
        Payment saveOrder = paymentService.getPayment(id);
        return saveOrder;
    }

    @GetMapping()
    @ResponseBody
    public List<Payment> getOrder() {
        List<Payment> payments = paymentService.getAllPayment();
        return payments;
    }
}
