package org.equipe.controllers;

import org.equipe.models.Task;
import org.equipe.dtos.TaskDTO;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api/v1/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskController {

    @GET
    @Path("/tasks")
    public List<TaskDTO> getTasks() {
        List<Task> tasks = Task.listAll();
        return tasks.stream()
                .map(TaskDTO::fromTask)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/tasks/{id}")
    public Response getTaskById(@PathParam("id") Long id) {
        Task task = Task.findById(id);
        if (task != null) {
            TaskDTO taskDTO = TaskDTO.fromTask(task);
            return Response.ok(taskDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/tasks")
    @Transactional
    public Response createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setCompleted(taskDTO.isCompleted());
        task.setAvailability(taskDTO.getAvailability());
        task.persistAndFlush();
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/tasks/{id}")
    @Transactional
    public Response updateTask(@PathParam("id") Long id, TaskDTO taskDTO) {
        Task task = Task.findById(id);
        if (task != null) {
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setDueDate(taskDTO.getDueDate());
            task.setCompleted(taskDTO.isCompleted());
            task.setAvailability(taskDTO.getAvailability());
            task.persist();
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/tasks/{id}")
    @Transactional
    public Response deleteTask(@PathParam("id") Long id) {
        Task task = Task.findById(id);
        if (task != null) {
            task.delete();
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
