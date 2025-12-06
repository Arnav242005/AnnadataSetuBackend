package com.arnav.demo.service;

import com.arnav.demo.model.dto.UserProfileDTO;
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

    public UserProfileDTO getMyProfile(Authentication auth){
        String email = auth.getName();
        return usersRepo.findProjectedByEmail(email);
    }
}
