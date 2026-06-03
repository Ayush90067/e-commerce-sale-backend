package com.ecommerce.backend.controller;

import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService
    ) {
        this.productService = productService;
    }

    // GET ALL PRODUCTS

    @GetMapping
    public List<Product> getProducts() {

        return productService.getAllProducts();
    }

    // GET PRODUCT BY ID

    @GetMapping("/{id}")
    public Product getProductById(
            @PathVariable Long id
    ) {

        return productService.getProductById(id);
    }

    // GET PRODUCTS BY CATEGORY

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(
            @PathVariable String category
    ) {

        return productService.getProductsByCategory(
                category
        );
    }

    // SEARCH PRODUCTS

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam String keyword
    ) {

        return productService.searchProducts(
                keyword
        );
    }

    // ADD PRODUCT

    @PostMapping
    public Product addProduct(
            @RequestBody Product product
    ) {

        return productService.addProduct(
                product
        );
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

    // DELETE PRODUCT

    @DeleteMapping("/{id}")
    public void deleteProduct(
            @PathVariable Long id
    ) {

        productService.deleteProduct(id);
    }
}