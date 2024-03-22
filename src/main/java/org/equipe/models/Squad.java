package org.equipe.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Squad extends PanacheEntityBase {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Sprint sprint;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
        name = "squad_participante",
        joinColumns = @JoinColumn(name = "squad_id"),
        inverseJoinColumns = @JoinColumn(name = "participante_id")
    )
    private List<Participante> participantes;

    // getters e setters

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
