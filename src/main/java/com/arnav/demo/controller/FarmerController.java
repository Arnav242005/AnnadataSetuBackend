package com.arnav.demo.controller;

import com.arnav.demo.model.dto.FarmerDTO;
import com.arnav.demo.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmer")
public class FarmerController {

    @Autowired
    private FarmerService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody FarmerDTO dto){

        String result = service.registerFarmer(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

}
