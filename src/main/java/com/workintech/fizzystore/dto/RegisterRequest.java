package com.workintech.fizzystore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    private String email;

    @NotNull
    @NotBlank
    @NotEmpty
    @JsonIgnore
    private String password;


}
