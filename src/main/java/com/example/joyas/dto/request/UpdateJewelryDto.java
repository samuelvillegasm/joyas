package com.example.joyas.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;

public record UpdateJewelryDto(
        @Max(50)
        String name,
        @Max(100)
        String material,
        @Positive
        Double weight,
        String specification,
        Boolean hasStone,
        Boolean isAvailableForSale
) {
}
