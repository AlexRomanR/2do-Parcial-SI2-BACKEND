package com.GestionAsisDocente.dto;

import lombok.Data;

@Data
public class PermisosRequest {

    private String nombre;

    public PermisosRequest(Integer id, String nombre) {

        this.nombre = nombre;
    }
}


