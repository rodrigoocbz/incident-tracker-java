package com.julio.rcp.common.domain.exceptions;

public class IncidenciaRunTimeException extends  RuntimeException {
    public IncidenciaRunTimeException(String message) {
        super(message);
    }

    public IncidenciaRunTimeException() {
    }

    public IncidenciaRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncidenciaRunTimeException(Throwable cause) {
        super(cause);
    }

    public IncidenciaRunTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
