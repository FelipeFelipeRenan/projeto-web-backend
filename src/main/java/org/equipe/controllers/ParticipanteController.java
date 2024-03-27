package org.equipe.controllers;

import org.equipe.models.*;

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

@Path("/api/v1/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParticipanteController {

    @GET
    @Path("/participantes")
    public Response getParticipantes() {
        List<Participante> participantes = Participante.listAll();
        return Response.ok(participantes).build();
    }

    @GET
    @Path("/{id}")
    public Response getParticipanteById(@PathParam("id") Long id) {
        Participante participante = Participante.findById(id);
        if (participante != null) {
            return Response.ok(participante).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/participantes")
    @Transactional
    public Response createParticipante(Participante participante) {
        participante.persistAndFlush();
        return Response.status(Response.Status.CREATED).build();
    }

    @PATCH
    @Path("/participantes/{id}/adicionar-tarefa/{taskId}")
    @Transactional
    public Response addTask(@PathParam("id") Long participanteId, @PathParam("taskId") Long taskId) {
        Participante participante = Participante.findById(participanteId);
        if (participante != null) {
            Task task = Task.findById(taskId);
            if (task != null && !task.isAvailable()) {
                participante.getTasks().add(task);
                task.setAvailable(false);
                task.persistAndFlush();
                participante.persistAndFlush();
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateParticipante(@PathParam("id") Long id, Participante participanteAtualizado) {
        Participante participante = Participante.findById(id);
        if (participante != null) {
            participante.setNome(participanteAtualizado.getNome());
            participante.setEmail(participanteAtualizado.getEmail());
            participante.setCargo(participanteAtualizado.getCargo());
            participante.setAtivo(participanteAtualizado.isAtivo());
            participante.persist();
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
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
