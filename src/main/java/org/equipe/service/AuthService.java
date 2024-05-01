package org.equipe.service;


import org.equipe.models.Participante;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AuthService {


    @Transactional
    public Participante authenticate(String username, String password) {
        // Busca o usuário no banco de dados pelo username
        Participante user = Participante.findByNome(username);

        
        
        // Verifica se o usuário existe e se a senha está correta (simplesmente para fins de demonstração)
        if (user != null && user.getPwd().equals(password)) {
            return user;
        }
        
        return null;
    }

    public boolean isUserInRole(String role) {
        // Implemente a lógica para verificar se o usuário tem o papel (role) especificado
        return false;
    }

    public String getUserName() {
        // Implemente a lógica para obter o nome do usuário autenticado
        return null;
    }
}


