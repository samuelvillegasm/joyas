package com.example.joyas.dto.response;

public record ListJewelryDto(
        Long id,
        String name,
        String material,
        Double weight,
        String specification,
        boolean hasStone,
        boolean isAvailableForSale
) {
}
