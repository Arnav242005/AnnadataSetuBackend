package com.arnav.demo.model.dto;

public record LoginRequest(
        String email,
        String password
) {
}
