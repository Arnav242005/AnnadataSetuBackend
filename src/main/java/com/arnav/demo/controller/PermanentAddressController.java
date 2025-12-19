package com.arnav.demo.controller;

import com.arnav.demo.model.dto.AddressDTO;
import com.arnav.demo.service.PermanentAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class PermanentAddressController {

    @Autowired
    private PermanentAddressService service;

    @PostMapping("/add/{id}")
    public ResponseEntity<?> addAddress(@RequestBody AddressDTO dto, @PathVariable int id){
        String result = service.saveUser(dto,id);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
