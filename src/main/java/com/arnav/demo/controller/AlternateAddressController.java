package com.arnav.demo.controller;

import com.arnav.demo.model.dto.AddressDTO;
import com.arnav.demo.service.AlternateAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/altaddress")
public class AlternateAddressController {

    @Autowired
    private AlternateAddressService service;

    @PostMapping("/add/{id}")
    public ResponseEntity<?> addAddress(@RequestBody AddressDTO dto, @PathVariable int id){
        String result = service.addAddress(dto,id);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
