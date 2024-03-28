package org.equipe.controllers;

import org.equipe.dtos.SprintDTO;
import org.equipe.models.Sprint;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/api/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SprintController {

    @GET
    @Path("/sprints")
    public Response getSprints() {
        List<Sprint> sprints = Sprint.listAll();
        List<SprintDTO> sprintDTOs = sprints.stream()
                .map(SprintDTO::fromSprint)
                .collect(Collectors.toList());
        return Response.ok(sprintDTOs).build();
    }

    @POST
    @Path("/sprints")
    @Transactional
    public Response criarSprint(SprintDTO sprintDTO) {
        Sprint sprint = sprintDTO.toSprint();
        sprint.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    // Outras operações relacionadas a Sprints, Dailys, Participantes, etc.
}
