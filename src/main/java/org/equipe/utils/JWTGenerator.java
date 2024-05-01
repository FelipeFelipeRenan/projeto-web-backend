package org.equipe.utils;


import org.equipe.config.JwtConfig;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class JWTGenerator {
    @Inject
    private JwtConfig jwtConfig;

    public String generateToken(Long userId, String username) {
        System.out.println("user id:" + userId);
        System.out.println("user name:" + username);
        return Jwt.subject(username)
                .claim("userId", userId)
                .expiresIn(jwtConfig.getTokenExpiration()) // Tempo de expiração em segundos
                .sign();
    }
}
