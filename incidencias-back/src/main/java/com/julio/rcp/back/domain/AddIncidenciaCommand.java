package com.julio.rcp.back.domain;

import com.julio.rcp.common.domain.model.Incidencia;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AddIncidenciaCommand {
    private LocalDate fecha;
    private String estado;
    private String empleado;
    private String descripcion;
}
