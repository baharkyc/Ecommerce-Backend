package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.ProductResponseDto;
import com.workintech.fizzystore.entity.Product;
import com.workintech.fizzystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("") //sort if parameter is given, don't sort if no parameter is given.
    public List<ProductResponseDto> getProducts(@RequestParam(name = "sort", required = false) String sort,
                                                @RequestParam(name = "categoryId", required = false) Long categoryId) {

        List<Product> products;

        products = productService.getProducts(categoryId, sort);

        return products
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


