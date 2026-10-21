package com.julio.rcp.back.infrastructure.impl;

import com.julio.rcp.back.domain.Repository;
import com.julio.rcp.back.infrastructure.Dao;
import com.julio.rcp.back.infrastructure.dto.IncidenciaRow;
import com.julio.rcp.back.infrastructure.mapper.DaoMapper;
import com.julio.rcp.common.domain.exceptions.IncidenciaNotFoundException;
import com.julio.rcp.common.domain.model.Incidencia;
import com.julio.rcp.common.domain.model.Progresos;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class RepositoryImpl implements Repository {
    private final Dao dao;
    private final DaoMapper daoMapper;

    @Inject
    public RepositoryImpl(Dao dao, DaoMapper daoMapper) {
        this.dao = dao;
        this.daoMapper = daoMapper;
    }

    @Override
    public Optional<Incidencia> findById(int id) {
        Optional<IncidenciaRow> incidenciaRow = dao.findById(id);
        if (incidenciaRow.isEmpty()) return Optional.empty();

        Incidencia incidencia = daoMapper.toIncidencia(incidenciaRow.get());
        incidencia.setProgresos(dao.findProgresosByIncidenciaId(id).stream()
                .map(daoMapper::toProgresos)
                .toList());
        return Optional.of(incidencia);
    }

    @Override
    public Progresos addProgreso(int id, Progresos progreso) throws IncidenciaNotFoundException {
        if (!dao.existsIncidencia(id)) {
            throw new IncidenciaNotFoundException(id);
        }

        return daoMapper.toProgresos(dao.addProgreso(id, daoMapper.toProgresoRow(progreso)));
    }
}
