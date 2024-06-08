package com.GestionAsisDocente.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles_permisos")
@IdClass(RolesPermisosId.class)
public class RolesPermisos {
    @Id
    @Column(name = "rol_id")
    private Integer rol_id;

    @Id
    @Column(name = "permiso_id")
    private Integer permiso_id;
}
