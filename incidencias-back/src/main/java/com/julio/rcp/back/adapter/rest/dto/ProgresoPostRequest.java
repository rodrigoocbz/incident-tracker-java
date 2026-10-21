package com.julio.rcp.back.adapter.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgresoPostRequest {
    @NotNull
    private LocalDate fecha;

    @NotBlank
    @Email
    private String empleado;

    @NotBlank
    private String descripcion;

    @NotBlank
    @Pattern(regexp = "OPEN|IN_PROGRESS|CLOSED")
    private String estado;
}
