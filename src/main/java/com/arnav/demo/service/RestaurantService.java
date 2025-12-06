package com.arnav.demo.service;

import com.arnav.demo.model.Restaurant;
import com.arnav.demo.model.Users;
import com.arnav.demo.model.dto.RestaurantDTO;
import com.arnav.demo.repo.RestaurantRepo;
import com.arnav.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RestaurantService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    public String registerRestaurant(RestaurantDTO dto){

        Users user = usersRepo.findById(dto.restaurantId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Restaurant rest = new Restaurant();
        rest.setUser(user);
        rest.setRestaurantName(dto.restaurantName());
        rest.setLicenseNo(dto.licenseNo());

        restaurantRepo.save(rest);

        return "Registered Successfully";
    }
}
