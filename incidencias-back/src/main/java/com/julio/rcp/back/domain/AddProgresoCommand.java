package com.julio.rcp.back.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddProgresoCommand {
    private LocalDate fecha;
    private String empleado;
    private String descripcion;
    private String estado;
}
