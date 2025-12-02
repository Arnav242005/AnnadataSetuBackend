package com.arnav.demo.model.dto;

public record LoginResponse(
        String token,
        String role,
        String full_name,
        int user_id
) {
}
