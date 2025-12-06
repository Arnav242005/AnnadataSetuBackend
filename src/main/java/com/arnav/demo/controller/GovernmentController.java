package com.arnav.demo.controller;

import com.arnav.demo.model.dto.GovernmentDTO;
import com.arnav.demo.service.GovernmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/govt")
@RestController
public class GovernmentController {

    @Autowired
    private GovernmentService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerGovt(@RequestBody GovernmentDTO govt){
        String result = service.registerGovernment(govt);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
}
