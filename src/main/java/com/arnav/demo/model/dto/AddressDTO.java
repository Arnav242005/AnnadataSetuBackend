package com.arnav.demo.model.dto;

public record AddressDTO(
         Integer id,
         String address,
         String city,
         String state,
         String pincode,
         String landmark
) {
}
