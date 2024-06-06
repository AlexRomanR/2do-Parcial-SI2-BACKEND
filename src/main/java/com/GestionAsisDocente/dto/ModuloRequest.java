package com.GestionAsisDocente.dto;

import lombok.Data;

@Data
public class ModuloRequest {
    private Integer numero;
    private String descripcion;
    private String ubicacion;
    private Integer facultad_id; // ID de la facultad a la que pertenece el módulo
}
