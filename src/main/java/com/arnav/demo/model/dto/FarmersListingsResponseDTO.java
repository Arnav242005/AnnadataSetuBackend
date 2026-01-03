package com.arnav.demo.model.dto;

import java.util.Date;

public record FarmersListingsResponseDTO(
        int listingId,
        int farmerId,
        String farmerName,
        String farmLocation,
        String typeOfCrop,
        double quantityAvailable,
        double unitPrice,
        String status,
        Date postDate
) {}
