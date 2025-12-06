package com.arnav.demo.repo;

import com.arnav.demo.model.Permanent_Shipping_Address;
import com.arnav.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Permanent_Shipping_AddressRepo extends JpaRepository<Permanent_Shipping_Address,Integer> {
    Optional<Permanent_Shipping_Address> findByUser(Users user);
}
