package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.CategoryResponseDto;
import com.workintech.fizzystore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<CategoryResponseDto> getCategories() {
        return categoryService
                .getAll()
                .stream()
                .map(category -> new CategoryResponseDto(
                        category.getId(),
                        category.getCategoryName(),
                        category.getImageUrl(),
                        category.getRating()
                ))
                .toList();
    }
}
