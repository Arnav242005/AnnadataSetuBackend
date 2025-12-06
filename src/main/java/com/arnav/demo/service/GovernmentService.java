package com.arnav.demo.service;

import com.arnav.demo.model.Government;
import com.arnav.demo.model.Users;
import com.arnav.demo.model.dto.GovernmentDTO;
import com.arnav.demo.repo.GovernmentRepo;
import com.arnav.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GovernmentService {

    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private GovernmentRepo repo;

    public String registerGovernment(GovernmentDTO dto){

        Users user = usersRepo.findById(dto.govtId())
                .orElseThrow(() -> new RuntimeException("User not found with ID = " + dto.govtId()));

        Government govt = new Government();
        govt.setUser(user);
        govt.setDesignation(dto.designation());
        govt.setDepartmentName(dto.departmentName());

        repo.save(govt);

        return "Registered Successfully";
    }
}
