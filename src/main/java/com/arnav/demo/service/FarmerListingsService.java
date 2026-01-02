package com.arnav.demo.service;

import com.arnav.demo.model.Farmer;
import com.arnav.demo.model.Farmers_Listings;
import com.arnav.demo.model.dto.FarmerListingsDTO;
import com.arnav.demo.repo.FarmerRepo;
import com.arnav.demo.repo.Farmers_ListingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FarmerListingsService {

    @Autowired
    private FarmerRepo farmerRepo;

    @Autowired
    private Farmers_ListingsRepo farmersListingsRepo;

    public String addListing(FarmerListingsDTO farmerListingsDTO) {

        Farmer farmer = farmerRepo.findById(farmerListingsDTO.farmerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Farmer Not Found"));

        Farmers_Listings farmersListings = new Farmers_Listings();
        farmersListings.setFarmer(farmer);
        farmersListings.setUnitPrice(farmerListingsDTO.unitPrice());
        farmersListings.setQuantityAvailable(farmerListingsDTO.quantityAvailable());
        farmersListings.setTypeOfCrop(farmerListingsDTO.typeOfCrop());
        farmersListings.setStatus(farmerListingsDTO.status());

        farmersListingsRepo.save(farmersListings);

        return "Success";
    }

    public List<Farmers_Listings> getFarmerListings(Integer farmerId) {
        return farmersListingsRepo.findByFarmerFarmerId(farmerId);
    }
}
