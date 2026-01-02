package com.arnav.demo.controller;

import com.arnav.demo.model.Farmers_Listings;
import com.arnav.demo.model.dto.FarmerListingsDTO;
import com.arnav.demo.service.FarmerListingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listings")
public class FarmerListingsController {

    @Autowired
    private FarmerListingsService service;

    @PostMapping("/add")
    public ResponseEntity<?> listCrops(@RequestBody FarmerListingsDTO farmerListingsDTO) {
        String result = service.addListing(farmerListingsDTO);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping("/{farmerId}/listings")
    public ResponseEntity<List<Farmers_Listings>> getListings(
            @PathVariable Integer farmerId) {
        return ResponseEntity.ok(service.getFarmerListings(farmerId));
    }
}
