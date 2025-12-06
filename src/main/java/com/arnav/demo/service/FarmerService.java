package com.arnav.demo.service;

import com.arnav.demo.model.Farmer;
import com.arnav.demo.model.Users;
import com.arnav.demo.model.dto.FarmerDTO;
import com.arnav.demo.repo.FarmerRepo;
import com.arnav.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FarmerService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private FarmerRepo farmerRepo;

    public String registerFarmer(FarmerDTO dto){

        Users user = usersRepo.findById(dto.farmerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));

        Farmer farm = new Farmer();
        farm.setUser(user);
        farm.setFarmLocation(dto.farmLocation());
        farm.setLandArea(dto.landArea());

        farmerRepo.save(farm);

        return "Registered Successfully";
    }
}
