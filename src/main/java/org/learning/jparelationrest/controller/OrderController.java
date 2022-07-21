package org.learning.jparelationrest.controller;

import java.util.List;
import org.learning.jparelationrest.modal.dto.OrderDTO;
import org.learning.jparelationrest.modal.entity.Order;
import org.learning.jparelationrest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseBody
    public Order saveOrder(@RequestBody OrderDTO orderDTO) {
        Order saveOrder = orderService.createOrder(orderDTO);
        return saveOrder;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Order getOrderById(@PathVariable Long id) {
        Order saveOrder = orderService.getOrder(id);
        return saveOrder;
    }

    @GetMapping()
    @ResponseBody
    public List<Order> getOrder() {
        List<Order> saveOrder = orderService.getAllOrder();
        return saveOrder;
    }
}
