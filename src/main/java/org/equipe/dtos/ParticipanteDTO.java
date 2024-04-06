package org.equipe.dtos;

import org.equipe.models.Participante;
import org.equipe.models.Task;
import org.equipe.models.Squad;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteDTO {

    private Long id;
    private String nome;
    private String email;
    private String cargo;
    private boolean ativo;
    private String pwd;
    private List<Long> tasksIds;
    private List<Long> squadsIds;

    public static ParticipanteDTO fromParticipante(Participante participante) {
        ParticipanteDTO dto = new ParticipanteDTO();
        dto.setId(participante.getId());
        dto.setNome(participante.getNome());
        dto.setEmail(participante.getEmail());
        dto.setCargo(participante.getCargo());
        dto.setAtivo(participante.isAtivo());
        dto.setTasksIds(getTasksIds(participante.getTasks()));
        dto.setSquadsIds(getSquadsIds(participante.getSquads()));
        return dto;
    }

    public static ParticipanteDTO fromParticipanteWithPwd(Participante participante){
        ParticipanteDTO dto = new ParticipanteDTO();
        dto.setId(participante.getId());
        dto.setNome(participante.getNome());
        dto.setEmail(participante.getEmail());
        dto.setCargo(participante.getCargo());
        dto.setAtivo(participante.isAtivo());
        dto.setTasksIds(getTasksIds(participante.getTasks()));
        dto.setSquadsIds(getSquadsIds(participante.getSquads()));
        dto.setPwd(participante.getPwd());
        return dto;
    }

    private static List<Long> getTasksIds(List<Task> tasks) {
        List<Long> ids = new ArrayList<>();
        for (Task task : tasks) {
            ids.add(task.getId());
        }
        return ids;
    }

    private static List<Long> getSquadsIds(List<Squad> squads) {
        List<Long> ids = new ArrayList<>();
        for (Squad squad : squads) {
            ids.add(squad.getId());
        }
        return ids;
    }

    public Participante toParticipante() {
        Participante participante = new Participante();
        participante.setNome(this.nome);
        participante.setEmail(this.email);
        participante.setCargo(this.cargo);
        participante.setAtivo(this.ativo);
        participante.setPwd(this.pwd);
        return participante;
    }

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

    public List<Long> getTasksIds() {
        return tasksIds;
    }

    public void setTasksIds(List<Long> tasksIds) {
        this.tasksIds = tasksIds;
    }

    public List<Long> getSquadsIds() {
        return squadsIds;
    }

    public void setSquadsIds(List<Long> squadsIds) {
        this.squadsIds = squadsIds;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    
}
