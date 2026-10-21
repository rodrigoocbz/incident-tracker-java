package com.julio.rcp.common.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incidencia {
    private int id;
    private String descripcion;
    private LocalDate fecha;
    private String email;
    private String prioridad;
    private String tipo;
    private List<Progresos> progresos;
}
