package org.equipe.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import java.util.List;

@Entity
public class Participante extends PanacheEntity {

    private String nome;
    private String email;
    private String cargo;
    private boolean ativo;

    @ManyToMany(mappedBy = "participantes")
    public List<Sprint> sprints;

    @ManyToMany(mappedBy = "participantes")
    private List<Daily> dailies;

    @ManyToMany
    @JoinTable(
        name = "participante_task",
        joinColumns = @JoinColumn(name = "participante_id"),
        inverseJoinColumns = @JoinColumn(name = "task_id"))
    public List<Task> tasks;

    public String getNome() {
        return nome;
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

    public List<Sprint> getSprints() {
        return sprints;
    }

    public List<Daily> getDailies() {
        return dailies;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public static List<Participante> findByNome(String nome) {
        return find("upper(nome)", nome.toUpperCase()).list();
    }

    public static PanacheQuery<Participante> findAtivos() {
        return find("ativo", true);
    }
}
