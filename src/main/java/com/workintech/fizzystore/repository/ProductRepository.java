package com.workintech.fizzystore.repository;

import com.workintech.fizzystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllByOrderByRatingAsc();
    List<Product> findAllByOrderByRatingDesc();

    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByCategoryIdOrderByPriceAsc(Long categoryId);
    List<Product> findByCategoryIdOrderByPriceDesc(Long categoryId);
    List<Product> findByCategoryIdOrderByRatingAsc(Long categoryId);
    List<Product> findByCategoryIdOrderByRatingDesc(Long categoryId);



}
