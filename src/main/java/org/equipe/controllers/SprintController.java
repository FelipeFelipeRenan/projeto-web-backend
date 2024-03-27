package org.equipe.controllers;

import org.equipe.models.*;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SprintController {

    // Operações relacionadas a Sprints

    @GET
    @Path("/sprints")
    public Response getSprints() {
        List<Sprint> sprints = Sprint.listAll();
        return Response.ok(sprints).build();
    }

    @POST
    @Path("/sprints")
    @Transactional
    public Response criarSprint(Sprint sprint) {
        sprint.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    // Operações relacionadas a Dailys


    // Operações relacionadas a Participantes
}

// Adicione operações adicionais conforme necessário
