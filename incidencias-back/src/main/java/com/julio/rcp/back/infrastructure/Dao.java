package com.julio.rcp.back.infrastructure;

import com.julio.rcp.back.infrastructure.dto.IncidenciaRow;
import com.julio.rcp.back.infrastructure.dto.ProgresoRow;

import java.util.List;
import java.util.Optional;

public interface Dao {
    Optional<IncidenciaRow> findById(int id);
    List<ProgresoRow> findProgresosByIncidenciaId(int id);
    boolean existsIncidencia(int id);
    ProgresoRow addProgreso(int id, ProgresoRow progresoRow);
}
