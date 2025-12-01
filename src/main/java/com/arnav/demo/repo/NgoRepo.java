package com.arnav.demo.repo;

import com.arnav.demo.model.Ngo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgoRepo extends JpaRepository<Ngo,Integer> {
}
