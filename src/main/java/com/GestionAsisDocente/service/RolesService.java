package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.RoleWithPermissionsDTO;
import com.GestionAsisDocente.dto.RolesPermisosRequest;
import com.GestionAsisDocente.dto.RolesRequest;
import com.GestionAsisDocente.entity.Permisos;
import com.GestionAsisDocente.entity.Roles;
import com.GestionAsisDocente.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Roles createRole(RolesRequest roleRequest) {
        Roles role = new Roles();
        role.setNombre(roleRequest.getNombre());
        return rolesRepository.save(role);
    }

    public Roles updateRole(Integer id, RolesRequest roleRequest) {
        Roles role = rolesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
        role.setNombre(roleRequest.getNombre());
        return rolesRepository.save(role);
    }

    public void deleteRole(Integer id) {
        Roles role = rolesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
        rolesRepository.delete(role);
    }

    public Roles getRoleById(Integer id) {
        return rolesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    }


}
