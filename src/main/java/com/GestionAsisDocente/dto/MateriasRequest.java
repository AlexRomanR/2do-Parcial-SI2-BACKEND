package com.GestionAsisDocente.dto;

import lombok.Data;

@Data
public class MateriasRequest {
    private String sigla;
    private String nombre;
    private Integer carrera_id;

}
