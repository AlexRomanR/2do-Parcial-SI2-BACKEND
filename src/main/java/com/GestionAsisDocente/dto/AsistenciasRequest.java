package com.GestionAsisDocente.dto;

import lombok.Data;

@Data
public class AsistenciasRequest {

    private Integer id;
    private Integer docente_materia_id;
    private String estado;
    private String hora_marcada;
    private String fecha;


}
