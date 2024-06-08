package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.PermisosRequest;
import com.GestionAsisDocente.entity.Permisos;
import com.GestionAsisDocente.service.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class PermisosController {

    @Autowired
    private PermisosService permisosService;

    @GetMapping("/get-all-permisos")
    public ResponseEntity<List<Permisos>> getAllPermisos() {
        List<Permisos> permisos = permisosService.getAllPermisos();
        return ResponseEntity.ok(permisos);
    }

    @PostMapping("/create-permiso")
    public ResponseEntity<Permisos> createPermiso(@RequestBody PermisosRequest permisoRequest) {
        Permisos permiso = permisosService.createPermiso(permisoRequest);
        return ResponseEntity.ok(permiso);
    }

    @PutMapping("/update-permiso/{id}")
    public ResponseEntity<Permisos> updatePermiso(@PathVariable Integer id, @RequestBody PermisosRequest permisoRequest) {
        Permisos updatedPermiso = permisosService.updatePermiso(id, permisoRequest);
        return ResponseEntity.ok(updatedPermiso);
    }

    @DeleteMapping("/delete-permiso/{id}")
    public ResponseEntity<Void> deletePermiso(@PathVariable Integer id) {
        permisosService.deletePermiso(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-permiso/{id}")
    public ResponseEntity<Permisos> getPermisoById(@PathVariable Integer id) {
        Permisos permiso = permisosService.getPermisoById(id);
        return ResponseEntity.ok(permiso);
    }
}
