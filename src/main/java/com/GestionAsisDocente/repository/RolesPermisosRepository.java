package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.entity.RolesPermisos;
import com.GestionAsisDocente.entity.RolesPermisosId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesPermisosRepository extends JpaRepository<RolesPermisos, RolesPermisosId> {
}
