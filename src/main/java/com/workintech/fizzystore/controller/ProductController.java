package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.ProductResponseDto;
import com.workintech.fizzystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<ProductResponseDto> getProducts() {
        return productService.getAll()
                .stream()
                .map(product -> new ProductResponseDto(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getStock(),
                        product.getReview(),
                        product.getCategoryId(),
                        product.getRating(),
                        product.getImage()
                ))
                .toList();
    }
}
