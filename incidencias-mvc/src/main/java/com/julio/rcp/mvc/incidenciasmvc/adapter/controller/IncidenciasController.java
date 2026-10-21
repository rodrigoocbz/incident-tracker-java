package com.julio.rcp.mvc.incidenciasmvc.adapter.controller;

import com.julio.rcp.mvc.incidenciasmvc.adapter.controller.dto.ProgresoForm;
import com.julio.rcp.mvc.incidenciasmvc.infrastructure.restclient.IncidenciasRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.MvcContext;
import jakarta.mvc.UriRef;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.mvc.security.CsrfProtected;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/incidencias")
public class IncidenciasController {
    @Inject
    @RestClient
    IncidenciasRestClient incidenciasRestClient;

    @Inject
    Models models;

    @Inject
    BindingResult bindingResult;

    @Inject
    MvcContext mvcContext;

    @POST
    @Path("/{id}/progresos")
    @Controller
    @CsrfProtected
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @UriRef("insertProgreso")
    public Response insertProgreso(@PathParam("id") int id,
                                   @Valid @BeanParam ProgresoForm form) {
        if (bindingResult.isFailed()) {
            Set<ParamError> allErrors = bindingResult.getAllErrors();
            Map<String, List<String>> errores = allErrors.stream()
                    .collect(Collectors.groupingBy(ParamError::getParamName,
                            Collectors.mapping(ParamError::getMessage, Collectors.toList())));

            models.put("id", id);
            models.put("form", form);
            models.put("errores", errores);
            return Response.ok("/jsps/insert_progreso.jsp").build();
        }

        incidenciasRestClient.insertProgreso(id, form);

        URI uri = mvcContext.uri("getFormularioInsertProgreso", Map.of("id", id));
        return Response.seeOther(uri).build();
    }
}
