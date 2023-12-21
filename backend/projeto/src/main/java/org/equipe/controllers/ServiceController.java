package org.equipe.controllers;

import java.util.List;

import org.equipe.models.Modelo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/v1")
public class ServiceController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModelo() {
        List<Modelo> modelos = Modelo.findAll().list();
        return Response.status(Status.OK).entity(modelos).build();
    }


}
