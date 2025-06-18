package com.workintech.fizzystore.dto;

public record CreditCardResponseDto (Long id, String nameOnCard, String cardNo,
                                     Long expireMonth, Long expireYear, Long userId) {
}
