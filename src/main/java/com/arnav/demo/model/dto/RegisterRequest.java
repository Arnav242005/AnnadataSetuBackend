package com.arnav.demo.model.dto;

public record RegisterRequest(
        String full_name,
        String email,
        String phone_no,
        String password,
        int role_id
) {
}
