package com.arnav.demo.Security;

import com.arnav.demo.model.Users;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.SignatureException;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET = "THIS_IS_A_32_CHAR_MINIMUM_SECRET_KEY!!";

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(Users user) {

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getUserRoles().getUserRoles())
                .claim("user_id", user.getUserId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)   // ✔ validates signature & expiration
                    .getBody()
                    .getSubject();

        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Token expired");

        } catch (MalformedJwtException e) {
            throw new RuntimeException("Invalid JWT format");

        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }

    public Date extractExpiration(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }


}
