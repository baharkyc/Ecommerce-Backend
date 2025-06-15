package com.workintech.fizzystore.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardRequestDto {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 100)
    private String nameOnCard;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 24)
    private String cardNo;

    private Long expireMonth;

    private Long expireYear;
}
