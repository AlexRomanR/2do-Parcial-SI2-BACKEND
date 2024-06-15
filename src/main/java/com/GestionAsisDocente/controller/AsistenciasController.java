package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.AsistenciasRequest;
import com.GestionAsisDocente.entity.Asistencias;
import com.GestionAsisDocente.service.AsistenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminuser")
public class AsistenciasController {

    @Autowired
    private AsistenciasService asistenciaService;

    @GetMapping("/get-all-asistencias")
    public ResponseEntity<List<Asistencias>> getAllAsistencias() {
        List<Asistencias> asistencias = asistenciaService.getAllAsistencias();
        return ResponseEntity.ok(asistencias);
    }

    @PostMapping("/create-asistencia")
    public ResponseEntity<Asistencias> createAsistencia(@RequestBody AsistenciasRequest asistenciaRequest) {
        Asistencias asistencia = asistenciaService.createAsistencia(asistenciaRequest);
        return ResponseEntity.ok(asistencia);
    }

    @PutMapping("/update-asistencia/{id}")
    public ResponseEntity<Asistencias> updateAsistencia(@PathVariable Integer id, @RequestBody AsistenciasRequest asistenciaRequest) {
        Asistencias updatedAsistencia = asistenciaService.updateAsistencia(id, asistenciaRequest);
        return ResponseEntity.ok(updatedAsistencia);
    }

    @DeleteMapping("/delete-asistencia/{id}")
    public ResponseEntity<Void> deleteAsistencia(@PathVariable Integer id) {
        asistenciaService.deleteAsistencia(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-asistencia/{id}")
    public Asistencias getAsistenciaById(@PathVariable Integer id) {
        return asistenciaService.getAsistenciaById(id);
    }

    @GetMapping("/get-asistencias-by-docentemateria/{docenteMateriaId}")
    public List<Asistencias> getAsistenciasByDocenteMateriaId(@PathVariable Integer docenteMateriaId) {
        return asistenciaService.getAsistenciasByDocenteMateriaId(docenteMateriaId);
    }

    @GetMapping("/get-asistencias-by-docente/{docenteId}")
    public List<Asistencias> getAsistenciasByDocenteId(@PathVariable Integer docenteId) {
        return asistenciaService.getAsistenciasByDocenteId(docenteId);
    }
}
