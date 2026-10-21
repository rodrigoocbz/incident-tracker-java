package com.julio.rcp.back.adapter.rest.provider;

import com.julio.rcp.common.adapter.rest.ErrorDto;
import com.julio.rcp.common.domain.exceptions.IncidenciaRunTimeException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IncidenciasRunTimeExceptionMapper implements ExceptionMapper<IncidenciaRunTimeException> {
    @Override
    public Response toResponse(IncidenciaRunTimeException exception) {
        return Response.serverError()
                .entity(ErrorDto.builder().message(exception.getMessage()).status("500").build())
                .build();
    }
}
