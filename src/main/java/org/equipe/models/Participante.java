package org.equipe.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    private String pwd;

    @JsonManagedReference
    @ManyToMany(mappedBy = "participantes", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Squad> squads;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "daily_participante",
            joinColumns = @JoinColumn(name = "participante_id"),
            inverseJoinColumns = @JoinColumn(name = "daily_id")
    )
    @Fetch(FetchMode.JOIN)
    private List<Daily> dailies;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "participante_task",
            joinColumns = @JoinColumn(name = "participante_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    @Fetch(FetchMode.JOIN)
    private List<Task> tasks;

    public Participante(String nome, String email, String cargo, boolean ativo, String pwd) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.ativo = ativo;
        this.pwd = pwd;
    }
    public Participante(){}

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public static Participante findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public static PanacheQuery<Participante> findAtivos() {
        return find("ativo", true);
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}