package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category findById(Long id);
    Category create(Category category);
    Category update(Long id, Category category);
    void deleteById(Long id);
}
