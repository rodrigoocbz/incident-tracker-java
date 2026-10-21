package com.julio.rcp.mvc.incidenciasmvc.infrastructure.restclient.provider;

import com.julio.rcp.common.adapter.rest.ErrorDto;
import com.julio.rcp.common.domain.exceptions.IncidenciaNotFoundException;
import com.julio.rcp.common.domain.exceptions.IncidenciaRunTimeException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

public class IncidenciasResponseExceptionMapper implements ResponseExceptionMapper<RuntimeException> {
    @Override
    public RuntimeException toThrowable(Response response) {
        ErrorDto errorDto = response.readEntity(ErrorDto.class);

        if (response.getStatus() == 404) {
            return new IncidenciaRunTimeException(errorDto.getMessage(), new IncidenciaNotFoundException(errorDto.getMessage()));
        }

        return new IncidenciaRunTimeException(errorDto.getMessage());
    }
}
