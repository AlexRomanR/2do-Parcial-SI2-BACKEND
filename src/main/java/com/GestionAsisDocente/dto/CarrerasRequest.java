package com.GestionAsisDocente.dto;

import lombok.Data;

@Data
public class CarrerasRequest {
    private String codigo;
    private String nombre;
    private Integer materia_id;

}
