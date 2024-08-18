package com.example.user_profile_service.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private RestTemplate restTemplate;

    private final String AUTH_SERVICE_URL = "http://localhost:8080/api/v1/auth/validate-token";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        String jwtToken = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            ResponseEntity<String> authResponse = restTemplate.getForEntity(AUTH_SERVICE_URL + "?token=" + jwtToken, String.class);

            if (authResponse.getStatusCode().is2xxSuccessful()) {
                System.out.println("Valid token");
                chain.doFilter(request, response);
            } else {
                System.out.println("Invalid token");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Token");
            }
        } else {
            // No token provided, respond with unauthorized status
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing Token");
        }
    }
}
