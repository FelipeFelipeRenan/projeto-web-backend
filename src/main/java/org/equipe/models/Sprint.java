package org.equipe.models;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;


@Entity
public class Sprint extends PanacheEntity{


    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String goal;

        @ManyToMany
    @JoinTable(
        name = "sprint_participante", // Nome da tabela intermediária
        joinColumns = @JoinColumn(name = "sprint_id"), // Coluna que referencia Sprint
        inverseJoinColumns = @JoinColumn(name = "participante_id") // Coluna que referencia Participante
    )
    private List<Participante> participantes;

    public String getName() {
        return name;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public String getGoal() {
        return goal;
    }
    public List<Participante> getParticipantes() {
        return participantes;
    }

    
    
    // Outros campos e relacionamentos
}
