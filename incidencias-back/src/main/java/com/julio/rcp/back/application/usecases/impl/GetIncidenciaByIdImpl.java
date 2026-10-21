package com.julio.rcp.back.application.usecases.impl;

import com.julio.rcp.back.application.usecases.GetIncidencia;
import com.julio.rcp.back.domain.Repository;
import com.julio.rcp.common.domain.exceptions.IncidenciaNotFoundException;
import com.julio.rcp.common.domain.model.Incidencia;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GetIncidenciaByIdImpl implements GetIncidencia {
    private final Repository repository;

    @Inject
    public GetIncidenciaByIdImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Incidencia execute(int id) throws IncidenciaNotFoundException {
        return repository.findById(id).orElseThrow(() -> new IncidenciaNotFoundException(id));
    }
}
