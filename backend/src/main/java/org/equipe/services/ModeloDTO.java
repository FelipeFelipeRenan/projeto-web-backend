package org.equipe.services;

public class ModeloDTO {

    public String name;
    public String email;
    public String cargo;
    public boolean ativo;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
}
