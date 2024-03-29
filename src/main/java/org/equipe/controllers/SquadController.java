package org.equipe.controllers;

import org.equipe.dtos.SquadDTO;
import org.equipe.models.Participante;
import org.equipe.models.Squad;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("api/v1/squads")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SquadController {

    @POST
    @Transactional
    public Response criarSquad(SquadDTO squadDTO) {
        Squad squad = squadDTO.toSquad();
        squad.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<SquadDTO> listarSquads() {
        List<Squad> squads = Squad.listAll();
        return squads.stream().map(SquadDTO::fromSquad).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response obterSquadPorId(@PathParam("id") Long id) {
        Squad squad = Squad.findById(id);
        if (squad != null) {
            SquadDTO squadDTO = SquadDTO.fromSquad(squad);
            return Response.ok(squadDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarSquad(@PathParam("id") Long id, SquadDTO squadDTOAtualizado) {
        Squad squad = Squad.findById(id);
        if (squad != null) {
            squadDTOAtualizado.setId(id);
            squad = squadDTOAtualizado.toSquad();
            squad.persist();
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarSquad(@PathParam("id") Long id) {
        Squad squad = Squad.findById(id);
        if (squad != null) {
            squad.delete();
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PATCH
    @Path("/{id}/adicionar-participante/{participanteId}")
    @Transactional
    public Response adicionarParticipanteAoSquad(@PathParam("id") Long squadId,
            @PathParam("participanteId") Long participanteId) {
        Squad squad = Squad.findById(squadId);
        if (squad != null) {
            Participante participante = Participante.findById(participanteId);
            if (participante != null) {
                squad.getParticipantes().add(participante);
                participante.getSquads().add(squad);
                squad.persistAndFlush();
                participante.persistAndFlush();
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
