package org.equipe.controllers;

import org.equipe.dtos.LoginRequest;
import org.equipe.dtos.TokenResponse;
import org.equipe.service.AuthService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {

    @Inject
    AuthService authService;

    @GET
    @Path("/secured")
    @RolesAllowed("user")
    public Response getSecuredResource() {
        // Seu código para o endpoint protegido aqui
        return Response.ok("Endpoint protegido acessado com sucesso!").build();
    }

    @POST
    @Path("/login")
    public Response login(LoginRequest loginRequest) {
        // Verificar as credenciais do usuário (por exemplo, no banco de dados)
        if (authService.isValidUser(loginRequest.getEmail(), loginRequest.getPassword())) {
            // Gerar o token JWT se as credenciais forem válidas
            System.out.println("foi direto pra o if");
            String token = authService.generateToken(loginRequest.getEmail());
            System.out.println("Token jwt: " + token);
            // Retornar o token JWT na resposta
            return Response.ok(new TokenResponse(token)).build();
        } else {
            // Retornar erro de autenticação se as credenciais forem inválidas
            System.out.println("foi direto pra o else");
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
