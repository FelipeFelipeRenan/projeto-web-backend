package org.equipe.dtos;

import java.util.List;

public class ParticipanteDTO {
    private Long id;
    private String nome;
    private String email;
    private String cargo;
    private boolean ativo;
    private List<Long> squadsIds;
    private List<Long> dailiesIds;
    private List<Long> tasksIds;

    // Construtores, getters e setters
    
    public ParticipanteDTO() {
    }

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

    public List<Long> getSquadsIds() {
        return squadsIds;
    }

    public void setSquadsIds(List<Long> squadsIds) {
        this.squadsIds = squadsIds;
    }

    public List<Long> getDailiesIds() {
        return dailiesIds;
    }

    public void setDailiesIds(List<Long> dailiesIds) {
        this.dailiesIds = dailiesIds;
    }

    public List<Long> getTasksIds() {
        return tasksIds;
    }

    public void setTasksIds(List<Long> tasksIds) {
        this.tasksIds = tasksIds;
    }

    public ParticipanteDTO(Long id, String nome, String email, String cargo, boolean ativo, List<Long> squadsIds, List<Long> dailiesIds, List<Long> tasksIds) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.ativo = ativo;
        this.squadsIds = squadsIds;
        this.dailiesIds = dailiesIds;
        this.tasksIds = tasksIds;
    }

}
