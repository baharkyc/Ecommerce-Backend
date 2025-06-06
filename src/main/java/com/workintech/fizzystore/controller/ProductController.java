package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.ProductResponseDto;
import com.workintech.fizzystore.entity.Product;
import com.workintech.fizzystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("") //sort if parameter is given, don't sort if no parameter is given.
    public List<ProductResponseDto> getProducts(@RequestParam(name = "sort", required = false) String sort) {

        List<Product> products;

        if (sort != null) {
            String[] parts = sort.split(":");
            String field = parts[0];
            String direction = parts.length > 1 ? parts[1] : "asc";

            if (field.equalsIgnoreCase("price")) {
                if (direction.equalsIgnoreCase("desc")) {
                    products = productService.sortByPriceDesc();
                } else {
                    products = productService.sortByPriceAsc();
                }
            } else {
                products = productService.getAll(); // default
            }
        } else {
            products = productService.getAll();
        }

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


