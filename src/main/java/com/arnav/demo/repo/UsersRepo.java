package com.arnav.demo.repo;

import com.arnav.demo.model.Users;
import com.arnav.demo.model.dto.UserProfileDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNo(String phoneNo);

    Optional<Users> findByEmail(String email);

    @Query("""
SELECT new com.arnav.demo.model.dto.UserProfileDTO(
    u.userId,
    u.fullName,
    u.email,
    u.phoneNo,
    u.userRoles.userRoles
)
FROM Users u
WHERE u.email = :email
""")
    UserProfileDTO findProjectedByEmail(String email);
}
