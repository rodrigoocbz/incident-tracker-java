package com.julio.rcp.back.adapter.rest;

import com.julio.rcp.back.adapter.rest.dto.ProgresoPostRequest;
import com.julio.rcp.back.adapter.rest.mapper.ResponseMapper;
import com.julio.rcp.back.application.usecases.AddProgreso;
import com.julio.rcp.back.application.usecases.GetIncidencia;
import com.julio.rcp.common.domain.exceptions.IncidenciaNotFoundException;
import com.julio.rcp.common.domain.model.Incidencia;
import com.julio.rcp.common.domain.model.Progresos;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/incidencias")
public class IncidenciasResource {
    private final ResponseMapper responseMapper;
    private final GetIncidencia getIncidencia;
    private final AddProgreso addProgreso;

    @Inject
    public IncidenciasResource(ResponseMapper responseMapper, GetIncidencia getIncidencia, AddProgreso addProgreso) {
        this.responseMapper = responseMapper;
        this.getIncidencia = getIncidencia;
        this.addProgreso = addProgreso;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) throws IncidenciaNotFoundException {
        Incidencia incidencia = getIncidencia.execute(id);
        return Response.ok(incidencia).build();
    }

    @POST
    @Path("/{id}/progresos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertProgreso(@PathParam("id") int id,
                                   @Valid ProgresoPostRequest request,
                                   @Context UriInfo uriInfo) throws IncidenciaNotFoundException {
        Progresos progreso = addProgreso.execute(id, responseMapper.toAddProgresoCommand(request));

        return Response.created(uriInfo.getBaseUriBuilder()
                        .path("/incidencias/{id}")
                        .resolveTemplate("id", id)
                        .build())
                .entity(progreso)
                .build();
    }
}
