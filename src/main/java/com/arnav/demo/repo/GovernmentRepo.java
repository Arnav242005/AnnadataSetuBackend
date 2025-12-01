package com.arnav.demo.repo;

import com.arnav.demo.model.Government;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernmentRepo extends JpaRepository<Government,Integer> {
}
