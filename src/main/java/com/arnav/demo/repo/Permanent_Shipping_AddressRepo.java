package com.arnav.demo.repo;

import com.arnav.demo.model.Permanent_Shipping_Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Permanent_Shipping_AddressRepo extends JpaRepository<Permanent_Shipping_Address,Integer> {
}
