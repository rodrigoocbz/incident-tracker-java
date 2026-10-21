package com.julio.rcp.back.adapter.rest.provider;

import com.julio.rcp.common.adapter.rest.ErrorDto;
import com.julio.rcp.common.domain.exceptions.IncidenciaException;
import com.julio.rcp.common.domain.exceptions.IncidenciaNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IncidenciasExceptionMapper implements ExceptionMapper<IncidenciaException> {
    @Override
    public Response toResponse(IncidenciaException exception) {
        if (exception instanceof IncidenciaNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(ErrorDto.builder().message(exception.getMessage()).status("404").build())
                    .build();
        }

        return Response.serverError()
                .entity(ErrorDto.builder().message(exception.getMessage()).status("500").build())
                .build();
    }
}
