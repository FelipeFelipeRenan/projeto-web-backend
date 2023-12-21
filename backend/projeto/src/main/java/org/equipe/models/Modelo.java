package org.equipe.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Modelo extends PanacheEntity{
    
    public String name;
    public String email;
    public String cargo;
    public boolean ativo;

    
}
