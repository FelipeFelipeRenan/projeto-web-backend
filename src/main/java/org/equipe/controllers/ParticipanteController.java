package org.equipe.controllers;

import org.equipe.models.*;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1/")
public class ParticipanteController {

    @GET
    @Path("/participantes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParticipantes() {
        List<Participante> participantes = Participante.listAll();
        return Response.ok(participantes).build();
    }

    @POST
    @Path("/participantes")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarParticipante(Participante participante) {
        participante.persistAndFlush();
        return Response.status(Response.Status.CREATED).build();
    }

    @PATCH
    @Path("/participantes/{id}/adicionar-tarefa/{taskId}")
    @Transactional
    public Response adicionarTarefa(@PathParam("id") Long participanteId, @PathParam("taskId") Long taskId) {
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
}
