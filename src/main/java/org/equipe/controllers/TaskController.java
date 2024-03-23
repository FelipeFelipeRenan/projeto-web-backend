package org.equipe.controllers;

import org.equipe.models.Task;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1")
public class TaskController {

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
    @Transactional
    public Response criarTask(Task task) {
        task.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/tasks/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deletarTask(@PathParam("id") Long id){
        boolean deleted = Task.deleteById(id);
        if (deleted) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
            
        }
    }

    @PATCH
    @Path("/tasks/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response atualizarDisponibilidadeTask(@PathParam("id") Long id){
        Task taskExistente = Task.findById(id);

        if (taskExistente != null) {
            taskExistente.setAvailable(true);
            taskExistente.persist();
            return Response.ok(taskExistente).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Task não encontrada").build();
        }
    }
    
}
