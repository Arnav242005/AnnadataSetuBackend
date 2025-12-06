package com.arnav.demo.service;

import com.arnav.demo.model.Ngo;
import com.arnav.demo.model.Users;
import com.arnav.demo.model.dto.NgoDTO;
import com.arnav.demo.repo.NgoRepo;
import com.arnav.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class NgoService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private NgoRepo ngoRepo;

    public String registerNGO(NgoDTO dto){

        Users user = usersRepo.findById(dto.ngoId())
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NO_CONTENT));

        Ngo ngo = new Ngo();
        ngo.setUser(user);
        ngo.setNgoName(dto.ngoName());
        ngo.setFocusArea(dto.focusArea());
        ngo.setRegistrationNo(dto.registrationNo());

        ngoRepo.save(ngo);

        return "Registered Successfully";
    }
}
