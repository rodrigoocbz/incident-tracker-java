package com.julio.rcp.common.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progresos {
    private int codigo;
    private int id;
    private LocalDate fecha;
    private String empleado;
    private String descripcion;
    private String estado;
}
