package com.ecommerce.backend.service;

import com.ecommerce.backend.entity.Product;

import com.ecommerce.backend.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(
            ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }

    // GET PRODUCTS

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    // ADD PRODUCT

    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    // DELETE PRODUCT

    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }

    // UPDATE PRODUCT

    public Product updateProduct(
            Long id,
            Product updatedProduct
    ) {

        Product product =
                productRepository.findById(id)
                        .orElseThrow();

        product.setName(updatedProduct.getName());

        product.setPrice(updatedProduct.getPrice());

        product.setCategory(updatedProduct.getCategory());

        product.setDescription(updatedProduct.getDescription());

        product.setImage(updatedProduct.getImage());

        return productRepository.save(product);
    }
    }


