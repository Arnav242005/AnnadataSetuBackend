package com.arnav.demo.controller;

import com.arnav.demo.model.dto.NgoDTO;
import com.arnav.demo.service.NgoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ngo")
@RestController
public class NgoController {

    @Autowired
    private NgoService service;

    @PostMapping("/register")
    public ResponseEntity<?> registerNgo(@RequestBody NgoDTO dto){

        String result = service.registerNGO(dto);

        return new ResponseEntity<>(result,HttpStatus.CREATED);

    }
}
