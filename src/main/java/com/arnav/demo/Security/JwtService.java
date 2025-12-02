package com.arnav.demo.Security;

import com.arnav.demo.model.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final String SECRET = "CHANGE_THIS_SECRET_KEY";

    public String generateToken(Users user) {

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getUserRoles().getUser_roles())
                .claim("user_id", user.getUser_id())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
