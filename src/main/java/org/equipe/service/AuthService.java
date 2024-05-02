package org.equipe.service;

import org.eclipse.microprofile.jwt.Claims;
import org.equipe.models.Participante;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthService {

    public boolean isValidUser(String email, String password) {
        Participante participante = Participante.findByEmail(email);
        return participante != null && participante.isAtivo() && participante.getPwd().equals(password);
    }

    public String generateToken(String email) {
        return Jwt.issuer("Quarkus") // Define o emissor do token
                .upn(email) // Define o nome de usuário
                .claim(Claims.groups.name(), "user") // Define as permissões/grupos do usuário (opcional)
                .expiresIn(86400) // Define o tempo de expiração do token em segundos (por exemplo, 24 horas)
                .sign(); // Assina e retorna o token JWT
    }
}
