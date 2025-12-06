package com.arnav.demo.model.dto;

import java.util.List;

public record FarmerDTO(
        Integer farmerId,
        String farmLocation,
        String landArea
) {
}
