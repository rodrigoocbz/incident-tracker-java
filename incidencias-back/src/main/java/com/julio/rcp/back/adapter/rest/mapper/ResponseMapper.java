package com.julio.rcp.back.adapter.rest.mapper;

import com.julio.rcp.back.adapter.rest.dto.ProgresoPostRequest;
import com.julio.rcp.back.domain.AddProgresoCommand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ResponseMapper {
    AddProgresoCommand toAddProgresoCommand(ProgresoPostRequest request);
}
