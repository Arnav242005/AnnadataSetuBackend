package com.arnav.demo.service;

import com.arnav.demo.Security.JwtService;
import com.arnav.demo.model.UserRoles;
import com.arnav.demo.model.Users;
import com.arnav.demo.model.dto.LoginRequest;
import com.arnav.demo.model.dto.LoginResponse;
import com.arnav.demo.model.dto.RegisterRequest;
import com.arnav.demo.repo.UserRolesRepo;
import com.arnav.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private UserRolesRepo userRolesRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String register(RegisterRequest request){
        if(usersRepo.existsByEmail(request.email())){
            return "Email Already Exists";
        }

        if(usersRepo.existsByPhoneNo(request.phoneNo())){
            return "Phone number is already exists !";
        }

        UserRoles role = userRolesRepo.findById(request.roleId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"Role not found"));

        Users user = new Users();
        user.setFullName(request.fullName());
        user.setEmail(request.email());
        user.setPhoneNo(request.phoneNo());
        user.setCreatedAt(new Date());
        user.setPassword_hash(passwordEncoder.encode(request.password()));
        user.setUserRoles(role);

        usersRepo.save(user);

        return "User registered sucessfully";
    }

    public LoginResponse login(LoginRequest request){

        Users user = usersRepo.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if(!passwordEncoder.matches(request.password(),user.getPassword_hash())){
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user);

        return new LoginResponse(
                token,
                user.getUserRoles().getUserRoles(),
                user.getFullName(),
                user.getUserId()
        );
    }
}
