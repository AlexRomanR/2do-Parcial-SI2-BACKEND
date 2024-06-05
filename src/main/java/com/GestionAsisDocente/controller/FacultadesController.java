package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.FacultadRequest;
import com.GestionAsisDocente.entity.Facultades;
import com.GestionAsisDocente.service.FacultadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class FacultadesController {

    @Autowired
    private FacultadesService facultadesService;

    @GetMapping("/get-all-facultades")
    public ResponseEntity<List<Facultades>> getAllFacultades() {
        List<Facultades> facultades = facultadesService.getAllFacultades();
        return ResponseEntity.ok(facultades);
    }


    @PostMapping("/create-facultad")
    public ResponseEntity<Facultades> createFacultad(@RequestBody FacultadRequest facultadRequest) {
        Facultades facultad = facultadesService.createFacultad(facultadRequest);
        return ResponseEntity.ok(facultad);
    }

    @PutMapping("/update-facultad/{id}")
    public ResponseEntity<Facultades> updateFacultad(@PathVariable Integer id, @RequestBody FacultadRequest facultadRequest) {
        Facultades updatedFacultad = facultadesService.updateFacultad(id, facultadRequest);
        return ResponseEntity.ok(updatedFacultad);
    }

    @DeleteMapping("/delete-facultad/{id}")
    public ResponseEntity<Void> deleteFacultad(@PathVariable Integer id) {
        facultadesService.deleteFacultad(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/get-facultad/{id}")
    public Facultades getFacultadById(@PathVariable Integer id) {
        return facultadesService.getFacultadById(id);
    }


}