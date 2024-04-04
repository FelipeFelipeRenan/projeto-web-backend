package org.equipe.controllers;

import org.equipe.dtos.ParticipanteDTO;
import org.equipe.models.Participante;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api/v1/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParticipanteController {

    @GET
    @Path("/participantes")
    public List<ParticipanteDTO> getParticipantes() {
        List<Participante> participantes = Participante.listAll();
        return participantes.stream()
                .map(ParticipanteDTO::fromParticipante) // Corrigido para utilizar fromParticipante
                .collect(Collectors.toList());
    }

    @GET
    @Path("/participantes/{id}")
    public Response getParticipanteById(@PathParam("id") Long id) {
        Participante participante = Participante.findById(id);
        if (participante != null) {
            ParticipanteDTO participanteDTO = ParticipanteDTO.fromParticipante(participante); // Corrigido para utilizar fromParticipante
            return Response.ok(participanteDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Path("/participantes")
    @Transactional
    public Response createParticipante(ParticipanteDTO participanteDTO) {
        Participante participante = new Participante(participanteDTO.getNome(), participanteDTO.getEmail(), participanteDTO.getCargo(), participanteDTO.isAtivo(), participanteDTO.getPwd());
        participante.persistAndFlush();
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/participantes/{id}")
    @Transactional
    public Response updateParticipante(@PathParam("id") Long id, ParticipanteDTO participanteDTO) {
        Participante participante = Participante.findById(id);
        if (participante != null) {
            participante.setNome(participanteDTO.getNome());
            participante.setEmail(participanteDTO.getEmail());
            participante.setCargo(participanteDTO.getCargo());
            participante.setAtivo(participanteDTO.isAtivo());
            participante.persist();
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/participantes/{id}")
    @Transactional
    public Response deleteParticipante(@PathParam("id") Long id) {
        Participante participante = Participante.findById(id);
        if (participante != null) {
            participante.delete();
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
