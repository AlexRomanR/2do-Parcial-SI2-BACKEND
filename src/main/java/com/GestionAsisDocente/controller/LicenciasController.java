package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.LicenciasRequest;
import com.GestionAsisDocente.entity.Licencias;
import com.GestionAsisDocente.service.LicenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminuser")
public class LicenciasController {

    @Autowired
    private LicenciasService licenciasService;

    @GetMapping("/get-all-licencias")
    public ResponseEntity<List<Licencias>> getAllLicencias() {
        List<Licencias> licencias = licenciasService.getAllLicencias();
        return ResponseEntity.ok(licencias);
    }

    @PostMapping("/create-licencia")
    public ResponseEntity<Licencias> createLicencia(@RequestBody LicenciasRequest licenciasRequest) {
        Licencias licencia = licenciasService.createLicencia(licenciasRequest);
        return ResponseEntity.ok(licencia);
    }

    @PutMapping("/update-licencia/{id}")
    public ResponseEntity<Licencias> updateLicencia(@PathVariable Integer id, @RequestBody LicenciasRequest licenciasRequest) {
        Licencias updatedLicencia = licenciasService.updateLicencia(id, licenciasRequest);
        return ResponseEntity.ok(updatedLicencia);
    }

    @DeleteMapping("/delete-licencia/{id}")
    public ResponseEntity<Void> deleteLicencia(@PathVariable Integer id) {
        licenciasService.deleteLicencia(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-licencia/{id}")
    public Licencias getLicenciaById(@PathVariable Integer id) {
        return licenciasService.getLicenciaById(id);
    }

    @GetMapping("/get-licencias-by-docentemateria/{docenteMateriaId}")
    public List<Licencias> getLicenciasByDocenteMateriaId(@PathVariable Integer docenteMateriaId) {
        return licenciasService.getLicenciasByDocenteMateriaId(docenteMateriaId);
    }

    @GetMapping("/get-licencias-by-docente/{docenteId}")
    public List<Licencias> getLicenciasByDocenteId(@PathVariable Integer docenteId) {
        return licenciasService.getLicenciasByDocenteId(docenteId);
    }
}
