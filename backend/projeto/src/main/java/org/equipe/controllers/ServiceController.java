package org.equipe.controllers;

import java.util.List;

import org.equipe.models.Modelo;
import org.equipe.services.ModeloDTO;
import org.equipe.services.ModeloMapper;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.quarkus.panache.common.Sort;
import java.util.stream.Collectors;

@Path("/api/v1")
public class ServiceController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModelo() {
        List<ModeloDTO> modelos = Modelo.findAll(Sort.by("name"))
        .stream()
        .map(ModeloMapper.INSTANCE::modeloToModeloDTOWithoutCargo)
        .collect(Collectors.toList());
        return Response.ok(modelos).build();
    }
}
