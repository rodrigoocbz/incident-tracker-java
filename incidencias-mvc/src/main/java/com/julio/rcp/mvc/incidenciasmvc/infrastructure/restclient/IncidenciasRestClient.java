package com.julio.rcp.mvc.incidenciasmvc.infrastructure.restclient;

import com.julio.rcp.common.domain.model.Progresos;
import com.julio.rcp.mvc.incidenciasmvc.adapter.controller.dto.ProgresoForm;
import com.julio.rcp.mvc.incidenciasmvc.infrastructure.restclient.provider.IncidenciasResponseExceptionMapper;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "rest.incidencias.url")
@RegisterProvider(IncidenciasResponseExceptionMapper.class)
public interface IncidenciasRestClient {
    @POST
    @Path("/incidencias/{id}/progresos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Progresos insertProgreso(@PathParam("id") int id, ProgresoForm form);
}
