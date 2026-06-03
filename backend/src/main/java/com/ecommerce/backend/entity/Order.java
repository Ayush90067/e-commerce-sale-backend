package com.ecommerce.backend.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String phone;

    private String address;

    private double totalAmount;

    public Order() {}
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(
            String customerName
    ) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(
            String phone
    ) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(
            String address
    ) {
        this.address = address;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(
            double totalAmount
    ) {
        this.totalAmount = totalAmount;
    }
}