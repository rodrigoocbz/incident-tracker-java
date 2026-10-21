package com.julio.rcp.common.domain.exceptions;

public class IncidenciaException extends  Exception {
    public IncidenciaException() {
    }

    public IncidenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IncidenciaException(Throwable cause) {
        super(cause);
    }

    public IncidenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncidenciaException(String message) {
        super(message);
    }

}
