package com.ecommerce.backend.controller;

import com.ecommerce.backend.entity.Product;

import com.ecommerce.backend.service.ProductService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/products")

@CrossOrigin("*")

public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService
    ) {
        this.productService = productService;
    }

    // GET PRODUCTS

    @GetMapping

    public List<Product> getProducts() {

        return productService.getAllProducts();
    }

    // ADD PRODUCT

    @PostMapping

    public Product addProduct(
            @RequestBody Product product
    ) {

        return productService.addProduct(product);
    }

    // DELETE PRODUCT

    @DeleteMapping("/{id}")

    public void deleteProduct(
            @PathVariable Long id
    ) {

        productService.deleteProduct(id);
    }

    // UPDATE PRODUCT

    @PutMapping("/{id}")

    public Product updateProduct(

            @PathVariable Long id,

            @RequestBody Product product
    ) {

        return productService.updateProduct(
                id,
                product
        );
    }

}
