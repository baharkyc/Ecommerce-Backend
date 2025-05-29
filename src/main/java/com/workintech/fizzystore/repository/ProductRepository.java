package com.workintech.fizzystore.repository;

import com.workintech.fizzystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
