package com.arnav.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfileDTO {
    private int userId;
    private String fullName;
    private String email;
    private String phoneNo;
    private String role;
}
