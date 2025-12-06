package com.arnav.demo.filters;

import com.arnav.demo.Security.JwtService;
import com.arnav.demo.model.Users;
import com.arnav.demo.repo.UsersRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsersRepo userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            try {
                // 🔥 VALIDATE token fully (signature + expiration + structure)
                String email = jwtService.extractEmail(token);

                // Proceed only if no authentication exists yet
                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                    Users user = userRepository.findByEmail(email).orElse(null);

                    if (user != null) {

                        SimpleGrantedAuthority authority =
                                new SimpleGrantedAuthority("ROLE_" + user.getUserRoles().getUserRoles());

                        UsernamePasswordAuthenticationToken authToken =
                                new UsernamePasswordAuthenticationToken(
                                        email,
                                        null,
                                        Collections.singletonList(authority)
                                );

                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                }
            }
            catch (Exception ex) {
                // 🔥 IMPORTANT: If token is invalid → DO NOT authenticate
                System.out.println("JWT ERROR: " + ex.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}
