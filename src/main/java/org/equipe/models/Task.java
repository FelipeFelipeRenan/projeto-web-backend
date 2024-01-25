package org.equipe.models;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Task extends PanacheEntity {

    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "daily_id")
    private Daily daily;

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public boolean isCompleted() {
        return completed;
    }
    public boolean isAvailable() {
        return available;
    }
    public Daily getDaily() {
        return daily;
    }

    

    
    // Outros campos e relacionamentos
}
