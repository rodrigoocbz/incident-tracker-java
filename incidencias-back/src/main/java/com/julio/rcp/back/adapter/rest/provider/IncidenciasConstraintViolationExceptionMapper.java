package com.julio.rcp.back.adapter.rest.provider;

import com.julio.rcp.common.adapter.rest.ErrorDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Provider
public class IncidenciasConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        List<ErrorDto> errorDtos = new ArrayList<>();
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            String message = violation.getMessage();
            String path = violation.getPropertyPath().toString();
            errorDtos.add(new ErrorDto(message, path));

        }
        return  Response.status(Response.Status.BAD_REQUEST).entity(errorDtos).build();
    }
}
