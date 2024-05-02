package org.equipe.dtos;

public class TokenResponse {
    private String token;

    // Construtor
    public TokenResponse(String token) {
        this.token = token;
    }

    // Getter e Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
