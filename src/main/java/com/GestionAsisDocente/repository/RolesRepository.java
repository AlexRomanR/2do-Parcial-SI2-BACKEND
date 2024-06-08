package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.dto.RoleWithPermissionsDTO;
import com.GestionAsisDocente.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
