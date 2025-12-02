package com.arnav.demo.model.dto;

public record RegisterRequest(
        String fullName,
        String email,
        String phoneNo,
        String password,
        int roleId
) {
}
