package com.arnav.demo.service;

import com.arnav.demo.model.Permanent_Shipping_Address;
import com.arnav.demo.model.Users;
import com.arnav.demo.model.dto.AddressDTO;
import com.arnav.demo.repo.Permanent_Shipping_AddressRepo;
import com.arnav.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PermanentAddressService {

    @Autowired
    private UsersRepo repo;

    @Autowired
    private Permanent_Shipping_AddressRepo addressrepo;

    public String saveUser(AddressDTO dto,int id){

        Users user = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"No User Found"));

        Permanent_Shipping_Address psa = new Permanent_Shipping_Address();
        psa.setUser(user);
        psa.setAddress(dto.address());
        psa.setCity(dto.city());
        psa.setState(dto.state());
        psa.setPincode(dto.pincode());
        psa.setLandmark(dto.landmark());

        addressrepo.save(psa);
        return "Saved User Address";
    }

}
