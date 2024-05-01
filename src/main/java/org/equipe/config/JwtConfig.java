package org.equipe.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JwtConfig {
    @ConfigProperty(name = "jwt.token-expiration")
    private long tokenExpiration;

    public long getTokenExpiration() {
        return tokenExpiration;
    }
}