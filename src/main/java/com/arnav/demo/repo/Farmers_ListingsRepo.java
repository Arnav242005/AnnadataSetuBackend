package com.arnav.demo.repo;

import com.arnav.demo.model.Farmers_Listings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Farmers_ListingsRepo extends JpaRepository<Farmers_Listings,Integer> {
}
