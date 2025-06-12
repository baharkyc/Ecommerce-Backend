package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.ProductResponseDto;
import com.workintech.fizzystore.entity.Product;
import com.workintech.fizzystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
                                                @RequestParam(name = "categoryId", required = false) Long categoryId,
                                                @RequestParam(name = "size", required = false) Integer size,
                                                @RequestParam(name = "page", required = false) Integer page) {


        List<Product> products;

        if (size == null || page == null) {
            // No pagination
            Object result = productService.getProducts(categoryId, sort);
            products = (result instanceof List) ? (List<Product>) result : ((Page<Product>) result).getContent();
        } else {
            // Pagination
            Pageable pageable = PageRequest.of(page, size);
            Object result = productService.getProducts(categoryId, sort, pageable);
            products = (result instanceof Page) ? ((Page<Product>) result).getContent() : (List<Product>) result;
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

    @GetMapping("/detail/{productId}")
    public ProductResponseDto getProductById (@PathVariable Long productId) {

        Product product = productService.findById(productId);

        return new ProductResponseDto(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getReview(),
                product.getCategoryId(),
                product.getRating(),
                product.getImage());
    }
}


