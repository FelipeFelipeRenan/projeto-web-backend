package org.equipe.controllers;

import org.equipe.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1")
public class ServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceController.class);


    // Operações relacionadas a Sprints

    @GET
    @Path("/sprints")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSprints() {
        List<Sprint> sprints = Sprint.listAll();
        return Response.ok(sprints).build();
    }

    @POST
    @Path("/sprints")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarSprint(Sprint sprint) {
        sprint.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    // Operações relacionadas a Dailys

    @GET
    @Path("/dailys")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDailys() {
        List<Daily> dailys = Daily.listAll();
        return Response.ok(dailys).build();
    }

    @POST
    @Path("/dailys")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarDaily(Daily daily) {
        daily.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    // Operações relacionadas a Tasks

    @GET
    @Path("/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTasks() {
        List<Task> tasks = Task.listAll();
        return Response.ok(tasks).build();
    }

    @POST
    @Path("/tasks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarTask(Task task) {
        task.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    // Operações relacionadas a Participantes

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
}

    // Adicione operações adicionais conforme necessário
