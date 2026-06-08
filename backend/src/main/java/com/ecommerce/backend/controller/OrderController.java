package com.ecommerce.backend.controller;

import com.ecommerce.backend.entity.Order;
import com.ecommerce.backend.service.OrderService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(
            OrderService orderService
    ) {
        this.orderService =
                orderService;
    }

    // PLACE ORDER

    @PostMapping
    public Order placeOrder(
            @RequestBody Order order
    ) {

        return orderService.saveOrder(order);
    }

    // ADMIN - ALL ORDERS

    @GetMapping
    public List<Order> getOrders() {

        return orderService.getAllOrders();
    }

    // USER - MY ORDERS

    @GetMapping("/my-orders")
    public List<Order> getMyOrders(

            @RequestParam String email

    ) {

        return orderService
                .getUserOrders(email);
    }
}