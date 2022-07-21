package org.learning.jparelationrest.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.learning.jparelationrest.mapper.OrderMapper;
import org.learning.jparelationrest.modal.dto.OrderDTO;
import org.learning.jparelationrest.modal.entity.Order;
import org.learning.jparelationrest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    public Order createOrder(OrderDTO orderDto) {
        Order order = orderMapper.toEntity(orderDto);

        return orderRepository.save(order);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Failed to find the order"));
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
