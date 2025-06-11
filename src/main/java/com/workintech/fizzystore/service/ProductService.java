package com.workintech.fizzystore.service;


import com.workintech.fizzystore.entity.Product;
import org.springframework.security.core.parameters.P;

import java.util.List;


public interface ProductService {
    List<Product> getAll();
    Product findById(Long id);
    Product create(Product product);
    Product update(Long id, Product product);
    void deleteById(Long id);

    List<Product> getProducts(Long categoryId, String sort);
}
