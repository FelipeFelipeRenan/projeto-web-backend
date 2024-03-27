package org.equipe.controllers;

import java.util.List;

import org.equipe.models.Daily;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1")
public class DailyControler {

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

}
