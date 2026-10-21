package com.julio.rcp.mvc.incidenciasmvc.adapter.controller;

import com.julio.rcp.mvc.incidenciasmvc.adapter.controller.dto.ProgresoForm;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@ApplicationScoped
@Path("/formularios/insert/incidencias")
public class FormularioController {
    @Inject
    Models models;

    @GET
    @Path("/{id}/progresos")
    @Controller
    @View("/jsps/insert_progreso.jsp")
    @UriRef("getFormularioInsertProgreso")
    public void getFormularioInsertProgreso(@PathParam("id") int id) {
        models.put("id", id);
        models.put("form", new ProgresoForm());
    }
}
