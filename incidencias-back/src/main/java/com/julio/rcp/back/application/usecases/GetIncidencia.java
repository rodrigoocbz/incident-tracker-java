package com.julio.rcp.back.application.usecases;

import com.julio.rcp.common.domain.exceptions.IncidenciaNotFoundException;
import com.julio.rcp.common.domain.model.Incidencia;

public interface GetIncidencia {
   Incidencia execute(int id) throws IncidenciaNotFoundException;
}
