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

    // GET ALL PRODUCTS

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET PRODUCT BY ID

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Product not found"
                        )
                );
    }

    // GET PRODUCTS BY CATEGORY

    public List<Product> getProductsByCategory(
            String category
    ) {
        return productRepository
                .findByCategory(category);
    }

    // SEARCH PRODUCTS

    public List<Product> searchProducts(
            String keyword
    ) {
        return productRepository
                .findByNameContainingIgnoreCase(
                        keyword
                );
    }

    // ADD PRODUCT

    public Product addProduct(
            Product product
    ) {
        return productRepository.save(product);
    }

    // UPDATE PRODUCT

    public Product updateProduct(
            Long id,
            Product updatedProduct
    ) {

        Product product =
                productRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Product not found"
                                )
                        );

        product.setName(
                updatedProduct.getName()
        );

        product.setPrice(
                updatedProduct.getPrice()
        );

        product.setCategory(
                updatedProduct.getCategory()
        );

        product.setDescription(
                updatedProduct.getDescription()
        );

        product.setImage(
                updatedProduct.getImage()
        );

        return productRepository.save(
                product
        );
    }

    // DELETE PRODUCT

    public void deleteProduct(Long id) {

        if (!productRepository.existsById(id)) {

            throw new RuntimeException(
                    "Product not found"
            );
        }

        productRepository.deleteById(id);
    }
}

