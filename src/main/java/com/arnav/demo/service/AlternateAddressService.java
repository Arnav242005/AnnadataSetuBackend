package com.arnav.demo.service;

import com.arnav.demo.model.Alternate_Shipping_Address;
import com.arnav.demo.model.Users;
import com.arnav.demo.model.dto.AddressDTO;
import com.arnav.demo.repo.Alternate_Shipping_AddressRepo;
import com.arnav.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AlternateAddressService {

    @Autowired
    private UsersRepo repo;

    @Autowired
    private Alternate_Shipping_AddressRepo addressrepo;

    public String addAddress(AddressDTO dto, int id) {

        Users user = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException( HttpStatus.NO_CONTENT,"User Not Found"));

        Alternate_Shipping_Address asa = new Alternate_Shipping_Address();
        asa.setUser(user);
        asa.setAddress(dto.address());
        asa.setCity(dto.city());
        asa.setPincode(dto.pincode());
        asa.setLandmark(dto.landmark());
        asa.setState(dto.state());

        addressrepo.save(asa);
        return "Alternate Address Added Sucessfully";
    }
}
