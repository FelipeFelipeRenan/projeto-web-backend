package org.equipe.services;

import org.equipe.models.Modelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Mapper
public interface ModeloMapper {

    ModeloMapper INSTANCE = Mappers.getMapper(ModeloMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cargo", target = "cargo")
    @Mapping(source = "ativo", target = "ativo")
    ModeloDTO modeloToModeloDTO(Modelo modelo);

    default ModeloDTO modeloToModeloDTOWithoutCargo(Modelo modelo) {
        if (modelo == null) {
            return null;
        }

        ModeloDTO dto = new ModeloDTO();
        dto.setName(modelo.getName());
        dto.setEmail(modelo.getEmail());
        dto.setAtivo(modelo.isAtivo());

        // O campo "cargo" não será mapeado

        return dto;
    }

    default ModeloDTO modeloToModeloDTOWithoutCargo(PanacheEntityBase entity) {
        if (entity == null) {
            return null;
        }

        // Faça a conversão adequada de PanacheEntityBase para Modelo
        Modelo modelo = (Modelo) entity;

        // Use o método modeloToModeloDTOWithoutCargo para realizar o mapeamento
        return modeloToModeloDTOWithoutCargo(modelo);
    }
}
