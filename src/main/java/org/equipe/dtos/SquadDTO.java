package org.equipe.dtos;

import org.equipe.models.Squad;
import org.equipe.models.Sprint;
import org.equipe.models.Participante;

import java.util.ArrayList;
import java.util.List;

public class SquadDTO {
    private Long id;
    private String nome;
    private String descricao;
    private SprintDTO sprint;
    private List<ParticipanteDTO> participantes;

    // Getters e setters

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public SprintDTO getSprint() {
        return sprint;
    }

    public void setSprint(SprintDTO sprint) {
        this.sprint = sprint;
    }

    public List<ParticipanteDTO> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<ParticipanteDTO> participantes) {
        this.participantes = participantes;
    }

    // Métodos de conversão

    public static SquadDTO fromSquad(Squad squad) {
        SquadDTO squadDTO = new SquadDTO();
        squadDTO.setId(squad.getId());
        squadDTO.setNome(squad.getNome());
        squadDTO.setDescricao(squad.getDescricao());
        if (squad.getSprint() != null) {
            squadDTO.setSprint(SprintDTO.fromSprint(squad.getSprint()));
        }
        squadDTO.setParticipantes(getParticipantesDTOs(squad.getParticipantes()));
        return squadDTO;
    }

    private static List<ParticipanteDTO> getParticipantesDTOs(List<Participante> participantes) {
        List<ParticipanteDTO> dtos = new ArrayList<>();
        for (Participante participante : participantes) {
            dtos.add(ParticipanteDTO.fromParticipante(participante));
        }
        return dtos;
    }

    public Squad toSquad() {
        Squad squad = new Squad();
        squad.setNome(this.nome);
        squad.setDescricao(this.descricao);
        if (this.sprint != null) {
            squad.setSprint(this.sprint.toSprint());
        }
        squad.setParticipantes(getParticipantesFromDTOs(this.participantes));
        return squad;
    }

    private List<Participante> getParticipantesFromDTOs(List<ParticipanteDTO> participantesDTOs) {
        List<Participante> participantes = new ArrayList<>();
        for (ParticipanteDTO dto : participantesDTOs) {
            participantes.add(dto.toParticipante());
        }
        return participantes;
    }
}
