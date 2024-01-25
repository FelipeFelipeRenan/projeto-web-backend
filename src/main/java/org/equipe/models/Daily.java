package org.equipe.models;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;


@Entity
public class Daily extends PanacheEntity {

    private LocalDate date;
    private String description;

      @ManyToMany
    @JoinTable(
        name = "daily_participante", // Nome da tabela intermediária
        joinColumns = @JoinColumn(name = "daily_id"), // Coluna que referencia Daily
        inverseJoinColumns = @JoinColumn(name = "participante_id") // Coluna que referencia Participante
    )
    private List<Participante> participantes;


    public LocalDate getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public List<Participante> getParticipantes() {
        return participantes;
    }
    
    
    // Outros campos e relacionamentos
}
