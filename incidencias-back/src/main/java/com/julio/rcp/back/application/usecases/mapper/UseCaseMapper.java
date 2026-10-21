package com.julio.rcp.back.application.usecases.mapper;

import com.julio.rcp.back.domain.AddProgresoCommand;
import com.julio.rcp.common.domain.model.Progresos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface UseCaseMapper {
    @Mapping(target = "codigo", ignore = true)
    @Mapping(target = "id", ignore = true)
    Progresos toProgresos(AddProgresoCommand command);
}
