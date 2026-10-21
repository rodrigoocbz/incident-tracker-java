package com.julio.rcp.mvc.incidenciasmvc.adapter.controller.dto;

import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.ws.rs.FormParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgresoForm {
    @FormParam("fecha")
    @MvcBinding
    @NotNull
    @NotBlank
    private String fecha;

    @FormParam("empleado")
    @MvcBinding
    @NotBlank
    @Email
    private String empleado;

    @FormParam("descripcion")
    @MvcBinding
    @NotBlank
    private String descripcion;

    @FormParam("estado")
    @MvcBinding
    @NotBlank
    @Pattern(regexp = "OPEN|IN_PROGRESS|CLOSED")
    private String estado;
}
