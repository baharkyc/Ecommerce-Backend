package com.workintech.fizzystore.dto;

import com.workintech.fizzystore.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponseDto(Long id, Long userId, Long addressId, String orderDate, Long creditCardId, BigDecimal price, List<Product> products) {
}
