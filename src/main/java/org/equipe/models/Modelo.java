package org.equipe.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.util.List;

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

    public static List<Modelo> findByName(String name){
        return find("upper(name)", name.toUpperCase()).list();
    }
 
   
}
