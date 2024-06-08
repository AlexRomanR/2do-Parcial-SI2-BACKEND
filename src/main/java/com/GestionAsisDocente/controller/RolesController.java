package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.RoleWithPermissionsDTO;
import com.GestionAsisDocente.dto.RolesRequest;
import com.GestionAsisDocente.entity.Permisos;
import com.GestionAsisDocente.entity.Roles;
import com.GestionAsisDocente.repository.PermisosRepository;
import com.GestionAsisDocente.repository.RolesRepository;
import com.GestionAsisDocente.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")

public class RolesController {

    @Autowired
    private RolesService rolesService;
    @Autowired
    private PermisosRepository permisosRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping("/get-all-roles")
    public ResponseEntity<List<Roles>> getAllRoles() {
        List<Roles> roles = rolesService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @PostMapping("/create-rol")
    public ResponseEntity<?> createRol(@RequestBody RolesRequest createRoleRequest) {
        try {
            // Buscar los permisos por sus IDs
            List<Permisos> permisos = createRoleRequest.getPermissions().stream()
                    .map(permisoId -> permisosRepository.findById(permisoId))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            if (permisos.isEmpty()) {
                return ResponseEntity.badRequest().body("No se encontraron permisos con los IDs proporcionados");
            }

            // Crear el nuevo rol y asignar los permisos
            Roles rol = new Roles();
            rol.setNombre(createRoleRequest.getNombre());
            rol.setPermissions(permisos);

            // Guardar el rol en el repositorio
            rolesRepository.save(rol);

            return ResponseEntity.ok(rol);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el rol: " + e.getMessage());
        }
    }

    @PutMapping("/update-rol/{id}")
    public ResponseEntity<?> updateRol(@PathVariable("id") Integer id, @RequestBody RolesRequest roleUpdateRequest) {
        Optional<Roles> existingRole = rolesRepository.findById(id);

        if (!existingRole.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Roles roleToUpdate = existingRole.get();
        roleToUpdate.setNombre(roleUpdateRequest.getNombre());

        List<Permisos> permisos = permisosRepository.findAllById(roleUpdateRequest.getPermissions());
        if (permisos.size() != roleUpdateRequest.getPermissions().size()) {
            return ResponseEntity.badRequest().body("Some permissions not found");
        }

        roleToUpdate.setPermissions(permisos);

        rolesRepository.save(roleToUpdate);

        return ResponseEntity.ok(roleToUpdate);
    }

    @DeleteMapping("/delete-rol/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        rolesService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-rol/{id}")
    public ResponseEntity<Roles> getRoleById(@PathVariable Integer id) {
        Roles role = rolesService.getRoleById(id);
        return ResponseEntity.ok(role);
    }


}
