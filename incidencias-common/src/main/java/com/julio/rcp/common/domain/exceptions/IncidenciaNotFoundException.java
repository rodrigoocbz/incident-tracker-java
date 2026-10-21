package com.julio.rcp.common.domain.exceptions;

public class IncidenciaNotFoundException extends IncidenciaException {
    public IncidenciaNotFoundException(String message) {
        super(message);
    }

    public  IncidenciaNotFoundException(int id) {
        super("Incidencia no encontrada con id:"+id);
    }
    public   IncidenciaNotFoundException() {
        super("Incidencia no encontrada");
    }
}
