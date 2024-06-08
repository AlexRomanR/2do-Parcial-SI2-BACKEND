package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.RolesPermisosRequest;
import com.GestionAsisDocente.entity.RolesPermisos;
import com.GestionAsisDocente.service.RolesPermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class RolesPermisosController {

    @Autowired
    private RolesPermisosService rolesPermisosService;

    @GetMapping("/get-all-roles-permisos")
    public ResponseEntity<List<RolesPermisos>> getAllRolesPermisos() {
        List<RolesPermisos> rolesPermisos = rolesPermisosService.getAllRolesPermisos();
        return ResponseEntity.ok(rolesPermisos);
    }

    @PostMapping("/create-roles-permisos")
    public ResponseEntity<RolesPermisos> createRolesPermisos(@RequestBody RolesPermisosRequest request) {
        RolesPermisos rolesPermisos = rolesPermisosService.createRolesPermisos(request);
        return ResponseEntity.ok(rolesPermisos);
    }

    @PutMapping("/update-roles-permisos")
    public ResponseEntity<RolesPermisos> updateRolesPermisos(@RequestBody RolesPermisosRequest request) {
        RolesPermisos updatedRolesPermisos = rolesPermisosService.updateRolesPermisos(request);
        return ResponseEntity.ok(updatedRolesPermisos);
    }

    @DeleteMapping("/delete-roles-permisos")
    public ResponseEntity<Void> deleteRolesPermisos(@RequestParam Integer rolId, @RequestParam Integer permisoId) {
        rolesPermisosService.deleteRolesPermisos(rolId, permisoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-roles-permisos")
    public ResponseEntity<RolesPermisos> getRolesPermisosById(@RequestParam Integer rolId, @RequestParam Integer permisoId) {
        RolesPermisos rolesPermisos = rolesPermisosService.getRolesPermisosById(rolId, permisoId);
        return ResponseEntity.ok(rolesPermisos);
    }
}
