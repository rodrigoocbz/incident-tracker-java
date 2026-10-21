package com.julio.rcp.back.domain;

import com.julio.rcp.common.domain.exceptions.IncidenciaNotFoundException;
import com.julio.rcp.common.domain.model.Incidencia;
import com.julio.rcp.common.domain.model.Progresos;

import java.util.Optional;

public interface Repository {
    Optional<Incidencia> findById(int id);
    Progresos addProgreso(int id, Progresos progreso) throws IncidenciaNotFoundException;
}
