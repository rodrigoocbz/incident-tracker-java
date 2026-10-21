package com.julio.rcp.back.application.usecases.impl;

import com.julio.rcp.back.application.usecases.AddProgreso;
import com.julio.rcp.back.application.usecases.mapper.UseCaseMapper;
import com.julio.rcp.back.domain.AddProgresoCommand;
import com.julio.rcp.back.domain.Repository;
import com.julio.rcp.common.domain.exceptions.IncidenciaNotFoundException;
import com.julio.rcp.common.domain.model.Progresos;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AddProgresoImpl implements AddProgreso {
    private final Repository repository;
    private final UseCaseMapper mapper;

    @Inject
    public AddProgresoImpl(Repository repository, UseCaseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Progresos execute(int id, AddProgresoCommand command) throws IncidenciaNotFoundException {
        return repository.addProgreso(id, mapper.toProgresos(command));
    }
}
