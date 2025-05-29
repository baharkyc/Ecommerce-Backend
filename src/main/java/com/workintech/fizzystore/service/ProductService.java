package com.workintech.fizzystore.service;


import com.workintech.fizzystore.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product findById(Long id);
    Product create(Product product);
    Product update(Long id, Product product);
    void deleteById(Long id);
}
