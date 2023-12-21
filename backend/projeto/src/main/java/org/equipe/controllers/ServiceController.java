package org.equipe.controllers;

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
    public Response getResponse(){
        return Response.status(Status.CREATED).entity("Hello").build();

    }
}
