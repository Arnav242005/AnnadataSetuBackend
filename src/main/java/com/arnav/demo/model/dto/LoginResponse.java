package com.arnav.demo.model.dto;

public record LoginResponse(
        String token,
        String role,
        String fullName,
        int userId
) {
}
