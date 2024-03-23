package org.equipe.controllers;

import org.equipe.models.Participante;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/api/v1/participantes")
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
}
