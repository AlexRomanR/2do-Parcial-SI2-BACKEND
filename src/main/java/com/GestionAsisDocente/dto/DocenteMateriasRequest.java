package com.GestionAsisDocente.dto;

import lombok.Data;

@Data
public class DocenteMateriasRequest {
    private Integer id;
    private Integer docente_id;
    private Integer materia_id;
    private String horario_inicio;
    private String horario_fin;
    private String grupo;
    private String dia;
    private Integer carrera_id;
    private Integer aula_id;
    private Integer modulo_id;
    private Integer facultad_id;

    // Getters and Setters
}

