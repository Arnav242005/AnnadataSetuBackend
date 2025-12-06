package com.arnav.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {
    private int userId;
    private String fullName;
    private String email;
    private String phoneNo;
    private String role;
    private String createdAt;

    private AddressDTO permanentAddress;
    private AddressDTO alternateAddress;

    private Object roleDetails; //dynamic based on role
}
