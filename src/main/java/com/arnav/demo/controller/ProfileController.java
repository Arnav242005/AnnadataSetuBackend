package com.arnav.demo.controller;

import com.arnav.demo.model.dto.UserProfileDTO;
import com.arnav.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/me")
    public UserProfileDTO getMyProfile(Authentication auth){
        return profileService.getMyProfile(auth);
    }
}
