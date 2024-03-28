// ParticipanteUseCase.java

package org.equipe.usecases;

import org.equipe.models.Participante;
import org.equipe.usecases.dto.CreateParticipanteDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ParticipanteUseCase {

    @Transactional
    public Long createParticipante(CreateParticipanteDTO createDTO) {
        Participante participante = new Participante();
        participante.setNome(createDTO.getNome());
        participante.setEmail(createDTO.getEmail());
        participante.setCargo(createDTO.getCargo());
        participante.setAtivo(true); // Definindo como ativo por padrão
        participante.persist(); // Usando o método persist() do PanacheEntityBase
        return participante.getId();
    }

    // Outros métodos do caso de uso, como updateParticipante, deleteParticipante, etc.
}
