package com.arnav.demo.repo;

import com.arnav.demo.model.Alternate_Shipping_Address;
import com.arnav.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Alternate_Shipping_AddressRepo extends JpaRepository<Alternate_Shipping_Address,Integer> {
    Optional<Alternate_Shipping_Address> findByUser(Users user);
}
