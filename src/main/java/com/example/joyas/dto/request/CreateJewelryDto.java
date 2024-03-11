package com.example.joyas.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record CreateJewelryDto(
        @NotNull(message = "name cannot be null")
        @NotBlank(message = "name cannot be blank")
        @Length(max = 50)
        String name,
        @NotNull(message = "name cannot be null")
        @NotBlank(message = "name cannot be blank")
        @Length(max = 100)
        String material,
        @Positive
        @NotNull
        Double weight,
        @NotNull(message = "name cannot be null")
        @NotBlank(message = "name cannot be blank")
        String specification,
        @NotNull
        Boolean hasStone,
        @NotNull
        Boolean isAvailableForSale
) {
}
