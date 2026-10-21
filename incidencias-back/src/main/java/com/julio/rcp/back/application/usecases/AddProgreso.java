package com.julio.rcp.back.application.usecases;

import com.julio.rcp.back.domain.AddProgresoCommand;
import com.julio.rcp.common.domain.exceptions.IncidenciaNotFoundException;
import com.julio.rcp.common.domain.model.Progresos;

public interface AddProgreso {
    Progresos execute(int id, AddProgresoCommand command) throws IncidenciaNotFoundException;
}
