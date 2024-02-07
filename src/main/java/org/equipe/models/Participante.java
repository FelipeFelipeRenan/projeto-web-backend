package org.equipe.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Participante extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private String email;
    private String cargo;
    private boolean ativo;

    @ManyToMany(mappedBy = "participantes")
    private List<Squad> squads;

    @ManyToMany
    @JoinTable(
        name = "daily_participante",
        joinColumns = @JoinColumn(name = "participante_id"),
        inverseJoinColumns = @JoinColumn(name = "daily_id")
    )
    private List<Daily> dailies;

    @ManyToMany
    @JoinTable(
        name = "participante_task",
        joinColumns = @JoinColumn(name = "participante_id"),
        inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> tasks;

    // getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    public List<Daily> getDailies() {
        return dailies;
    }

    public void setDailies(List<Daily> dailies) {
        this.dailies = dailies;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public static List<Participante> findByNome(String nome) {
        return find("upper(nome)", nome.toUpperCase()).list();
    }

    public static PanacheQuery<Participante> findAtivos() {
        return find("ativo", true);
    }
}
