package org.equipe.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Daily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String description;
    
    public Long getId() {
        return id;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    
    
    // Outros campos e relacionamentos
}
