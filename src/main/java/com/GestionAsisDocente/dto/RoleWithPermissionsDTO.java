package com.GestionAsisDocente.dto;
import lombok.Data;

import java.util.List;

@Data
public class RoleWithPermissionsDTO {
    private Integer id;
    private String nombre;
    private List<PermisosRequest> permisos;

    public RoleWithPermissionsDTO(Integer id, String nombre, List<PermisosRequest> permisos) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = permisos;
    }

}
