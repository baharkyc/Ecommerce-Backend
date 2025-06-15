package com.workintech.fizzystore.dto;

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
public class AddressRequestDto {

    @Size(max = 50)
    @NotNull
    private String title;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    private String surname;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 14)
    private String phoneNumber;

    @NotNull
    @NotEmpty
    @NotBlank
    private String city;

    @NotNull
    @NotEmpty
    @NotBlank
    private String district;

    @NotNull
    @NotEmpty
    @NotBlank
    private String neighborhood;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 300)
    private String address;
}
