package com.julio.rcp.back.infrastructure.mapper;

import com.julio.rcp.back.infrastructure.dto.IncidenciaRow;
import com.julio.rcp.back.infrastructure.dto.ProgresoRow;
import com.julio.rcp.common.domain.model.Incidencia;
import com.julio.rcp.common.domain.model.Progresos;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface DaoMapper {
    Incidencia toIncidencia(IncidenciaRow incidenciaRow);
    ProgresoRow toProgresoRow(Progresos progreso);
    Progresos toProgresos(ProgresoRow progresoRow);
}
