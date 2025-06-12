package com.workintech.fizzystore.repository;

import com.workintech.fizzystore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    Page<Product> findAllByOrderByPriceAsc(Pageable pageable);
    Page<Product> findAllByOrderByPriceDesc(Pageable pageable);
    Page<Product> findAllByOrderByRatingAsc(Pageable pageable);
    Page<Product> findAllByOrderByRatingDesc(Pageable pageable);

    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);

    Page<Product> findByCategoryIdOrderByPriceAsc(Long categoryId, Pageable pageable);
    Page<Product> findByCategoryIdOrderByPriceDesc(Long categoryId, Pageable pageable);
    Page<Product> findByCategoryIdOrderByRatingAsc(Long categoryId, Pageable pageable);
    Page<Product> findByCategoryIdOrderByRatingDesc(Long categoryId, Pageable pageable);



}
