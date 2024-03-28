package org.equipe.dtos;

import org.equipe.models.Sprint;
import org.equipe.models.Participante;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SprintDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String goal;
    private List<Long> participantesIds;

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public List<Long> getParticipantesIds() {
        return participantesIds;
    }

    public void setParticipantesIds(List<Long> participantesIds) {
        this.participantesIds = participantesIds;
    }

    // Métodos de conversão

    public static SprintDTO fromSprint(Sprint sprint) {
        SprintDTO sprintDTO = new SprintDTO();
        sprintDTO.setId(sprint.getId());
        sprintDTO.setName(sprint.getName());
        sprintDTO.setStartDate(sprint.getStartDate());
        sprintDTO.setEndDate(sprint.getEndDate());
        sprintDTO.setGoal(sprint.getGoal());
        sprintDTO.setParticipantesIds(getParticipantesIds(sprint.getParticipantes()));
        return sprintDTO;
    }

    private static List<Long> getParticipantesIds(List<Participante> participantes) {
        return participantes.stream()
                .map(Participante::getId)
                .collect(Collectors.toList());
    }

    public Sprint toSprint() {
        Sprint sprint = new Sprint();
        sprint.setName(this.name);
        sprint.setStartDate(this.startDate);
        sprint.setEndDate(this.endDate);
        sprint.setGoal(this.goal);
        // Note que aqui não estamos mapeando participantes diretamente para Sprint, pois não há um mapeamento bidirecional no DTO
        return sprint;
    }
}
