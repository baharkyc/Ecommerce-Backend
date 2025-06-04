package com.workintech.fizzystore.dto;

import java.math.BigDecimal;

public record ProductResponseDto(Long id, String name, String description, BigDecimal price, String stock, String review, Long cstegoryId, Float rating, String image) {
}
