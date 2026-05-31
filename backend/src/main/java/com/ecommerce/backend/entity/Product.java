package com.ecommerce.backend.entity;

import jakarta.persistence.*;

@Entity

public class Product {

    @Id

    @GeneratedValue(strategy =
            GenerationType.IDENTITY)

    private Long id;

    private String name;

    private double price;

    private String category;

    private String description;

    private String image;

    // DEFAULT CONSTRUCTOR

    public Product() {
    }

    // GET ID

    public Long getId() {

        return id;
    }

    // SET ID

    public void setId(Long id) {

        this.id = id;
    }

    // GET NAME

    public String getName() {

        return name;
    }

    // SET NAME

    public void setName(String name) {

        this.name = name;
    }

    // GET PRICE

    public double getPrice() {

        return price;
    }

    // SET PRICE

    public void setPrice(double price) {

        this.price = price;
    }

    // GET CATEGORY

    public String getCategory() {

        return category;
    }

    // SET CATEGORY

    public void setCategory(String category) {

        this.category = category;
    }

    // GET DESCRIPTION

    public String getDescription() {

        return description;
    }

    // SET DESCRIPTION

    public void setDescription(String description) {

        this.description = description;
    }

    // GET IMAGE

    public String getImage() {

        return image;
    }

    // SET IMAGE

    public void setImage(String image) {

        this.image = image;
    }
}