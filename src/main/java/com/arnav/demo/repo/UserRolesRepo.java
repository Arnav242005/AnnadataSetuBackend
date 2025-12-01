package com.arnav.demo.repo;

import com.arnav.demo.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepo extends JpaRepository<UserRoles,Integer>{
}
