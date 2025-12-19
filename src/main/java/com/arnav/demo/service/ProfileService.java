package com.arnav.demo.service;

import com.arnav.demo.model.dto.*;
import com.arnav.demo.model.Users;
import com.arnav.demo.model.dto.*;
import com.arnav.demo.repo.Alternate_Shipping_AddressRepo;
import com.arnav.demo.repo.Permanent_Shipping_AddressRepo;
import com.arnav.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private Permanent_Shipping_AddressRepo permanentRepo;

    @Autowired
    private Alternate_Shipping_AddressRepo alternateRepo;

    public UserProfileDTO getMyProfile(Authentication auth) {

        String email = auth.getName();

        Users user = usersRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        UserProfileDTO dto = new UserProfileDTO();

        dto.setUserId(user.getUserId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNo(user.getPhoneNo());
        dto.setRole(user.getUserRoles().getUserRoles());
        dto.setCreatedAt(user.getCreatedAt().toString());

        permanentRepo.findByUser(user).ifPresent(psa -> {
            dto.setPermanentAddress(
                    new AddressDTO(psa.getId(),
                            psa.getAddress(),
                            psa.getCity(),
                            psa.getState(),
                            psa.getPincode(),
                            psa.getLandmark())
            );
        });

        alternateRepo.findByUser(user).ifPresent(asa -> {
            dto.setAlternateAddress(
                    new AddressDTO(asa.getId(),
                            asa.getAddress(),
                            asa.getCity(),
                            asa.getState(),
                            asa.getPincode(),
                            asa.getLandmark())
            );
        });

        switch (dto.getRole()) {

            case "FARMER" -> {
                if (user.getFarmer() != null)
                    dto.setRoleDetails(
                            new FarmerDTO(
                                    user.getFarmer().getFarmerId(),
                                    user.getFarmer().getFarmLocation(),
                                    user.getFarmer().getLandArea()
                            )
                    );
            }

            case "RESTAURANT" -> {
                if (user.getRestaurant() != null)
                    dto.setRoleDetails(
                            new RestaurantDTO(
                                    user.getRestaurant().getRestaurantId(),
                                    user.getRestaurant().getRestaurantName(),
                                    user.getRestaurant().getLicenseNo()
                            )
                    );
            }

            case "NGO" -> {
                if (user.getNgo() != null)
                    dto.setRoleDetails(
                            new NgoDTO(
                                    user.getNgo().getNgoId(),
                                    user.getNgo().getNgoName(),
                                    user.getNgo().getFocusArea(),
                                    user.getNgo().getRegistrationNo()
                            )
                    );
            }

            case "GOVT" -> {
                if (user.getGovernment() != null)
                    dto.setRoleDetails(
                            new GovernmentDTO(
                                    user.getGovernment().getGovtId(),
                                    user.getGovernment().getDepartmentName(),
                                    user.getGovernment().getDesignation()
                            )
                    );
            }
        }

        return dto;
    }
}
