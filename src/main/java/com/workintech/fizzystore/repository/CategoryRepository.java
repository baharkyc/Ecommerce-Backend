package com.workintech.fizzystore.repository;

import com.workintech.fizzystore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
