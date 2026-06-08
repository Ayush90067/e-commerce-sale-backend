package com.ecommerce.backend.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String customerName;

    private String phone;

    private String address;

    // NEW FIELD
    private String userEmail;

    private double totalAmount;

    // NEW FIELD
    private String status;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    public Order() {

        this.status = "Pending";
    }

    // ID

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // CUSTOMER NAME

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(
            String customerName
    ) {
        this.customerName = customerName;
    }

    // PHONE

    public String getPhone() {
        return phone;
    }

    public void setPhone(
            String phone
    ) {
        this.phone = phone;
    }

    // ADDRESS

    public String getAddress() {
        return address;
    }

    public void setAddress(
            String address
    ) {
        this.address = address;
    }

    // USER EMAIL

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(
            String userEmail
    ) {
        this.userEmail = userEmail;
    }

    // TOTAL AMOUNT

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(
            double totalAmount
    ) {
        this.totalAmount = totalAmount;
    }

    // STATUS

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {
        this.status = status;
    }

    // ITEMS

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(
            List<OrderItem> items
    ) {
        this.items = items;
    }
}