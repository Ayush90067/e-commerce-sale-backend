package com.ecommerce.backend.service;

import com.ecommerce.backend.entity.Order;
import com.ecommerce.backend.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(
            OrderRepository orderRepository
    ) {
        this.orderRepository =
                orderRepository;
    }

    // SAVE ORDER

    public Order saveOrder(
            Order order
    ) {

        if (order.getStatus() == null ||
                order.getStatus().isEmpty()) {

            order.setStatus("Pending");
        }

        return orderRepository.save(order);
    }

    // ADMIN - GET ALL ORDERS

    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    // USER - GET MY ORDERS

    public List<Order> getUserOrders(
            String email
    ) {

        return orderRepository
                .findByUserEmail(email);
    }
}