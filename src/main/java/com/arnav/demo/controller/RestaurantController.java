package com.arnav.demo.controller;

import com.arnav.demo.model.dto.RestaurantDTO;
import com.arnav.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RestaurantDTO dto){

        String result = service.registerRestaurant(dto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }
}
