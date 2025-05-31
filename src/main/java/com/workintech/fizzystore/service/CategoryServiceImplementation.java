package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Address;
import com.workintech.fizzystore.entity.Category;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImplementation implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Category with id: " + id + " not found.", HttpStatus.NOT_FOUND));
        return category;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        Category categoryToUpdate = categoryRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Category with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        if (category.getCategoryName() != null) {
            categoryToUpdate.setCategoryName(category.getCategoryName());
        }

        return categoryRepository.save(categoryToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if(!categoryRepository.existsById(id)) {
            throw new FizzyStoreException("Category with id: " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        categoryRepository.deleteById(id);
    }
}
