package com.GestionAsisDocente.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class RolesPermisosId implements Serializable {
    private Integer rol_id;
    private Integer permiso_id;
}
