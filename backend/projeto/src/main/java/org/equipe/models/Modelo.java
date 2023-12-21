package org.equipe.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Modelo extends PanacheEntity{
    
    private String name;
    private String email;
    private String cargo;
    private boolean ativo;
    
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
