package org.equipe.services;

import org.equipe.models.Modelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModeloMapper {

    ModeloMapper INSTANCE = Mappers.getMapper(ModeloMapper.class);

    @Mapping(target = "ativo", ignore = true)
    ModeloDTO modeloToModeloDTO(Modelo modelo); 
}