package com.julio.rcp.mvc.incidenciasmvc;

import jakarta.mvc.form.FormMethodOverwriter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.Map;

@ApplicationPath("/mvc")
public class FrontendApplication extends Application
{


    @Override
    public Map<String, Object> getProperties()
    {
        return Map.of(
                FormMethodOverwriter.FORM_METHOD_OVERWRITE, FormMethodOverwriter.Options.ENABLED
        );

    }
}