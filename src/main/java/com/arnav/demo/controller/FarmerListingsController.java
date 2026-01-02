package com.arnav.demo.controller;

import com.arnav.demo.service.FarmerListingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listings")
public class FarmerListingsController {

    @Autowired
    private FarmerListingsService service;




}
