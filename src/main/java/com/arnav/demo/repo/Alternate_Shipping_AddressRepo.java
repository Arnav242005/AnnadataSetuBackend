package com.arnav.demo.repo;

import com.arnav.demo.model.Alternate_Shipping_Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Alternate_Shipping_AddressRepo extends JpaRepository<Alternate_Shipping_Address,Integer> {
}
