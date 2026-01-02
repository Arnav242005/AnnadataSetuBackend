package com.arnav.demo.model.dto;

public record FarmerListingsDTO(
        Integer farmerId,
        String typeOfCrop,
        double quantityAvailable,
        double unitPrice,
        String status
) {
}
