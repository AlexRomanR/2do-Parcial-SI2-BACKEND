package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.LicenciasRequest;
import com.GestionAsisDocente.entity.DocenteMaterias;
import com.GestionAsisDocente.entity.Licencias;
import com.GestionAsisDocente.service.DocenteMateriasService;
import com.GestionAsisDocente.service.LicenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adminuser")
public class LicenciasController {


    @Autowired
    private LicenciasService licenciasService;

    @Autowired
    private DocenteMateriasService docenteMateriasService;

    @GetMapping("/get-all-licencias")
    public ResponseEntity<List<Licencias>> getAllLicencias() {
        List<Licencias> licencias = licenciasService.findAll();
        return ResponseEntity.ok(licencias);
    }

    @GetMapping("/get-licencia/{id}")
    public ResponseEntity<Licencias> getLicenciaById(@PathVariable Integer id) {
        return licenciasService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create-licencia")
    public ResponseEntity<Licencias> createLicencia(@RequestBody LicenciasRequest licenciasRequest) {
        Licencias licencia = new Licencias();
        licencia.setMotivo(licenciasRequest.getMotivo());
        DocenteMaterias docenteMateria = docenteMateriasService.findById(licenciasRequest.getDocenteMateriaId())
                .orElseThrow(() -> new RuntimeException("Docente Materia no encontrado"));
        licencia.setDocenteMateria(docenteMateria);
        licencia.setEstado(false); // Default to false
        licencia.setFechaActual(new Date()); // Set current date
        Licencias savedLicencia = licenciasService.save(licencia);
        return ResponseEntity.ok(savedLicencia);
    }

    @PutMapping("/update-licencia/{id}")
    public ResponseEntity<Licencias> updateLicencia(@PathVariable Integer id, @RequestBody LicenciasRequest licenciasRequest) {
        Licencias licencia = licenciasService.findById(id)
                .orElseThrow(() -> new RuntimeException("Licencia no encontrada"));
        licencia.setMotivo(licenciasRequest.getMotivo());
        DocenteMaterias docenteMateria = docenteMateriasService.findById(licenciasRequest.getDocenteMateriaId())
                .orElseThrow(() -> new RuntimeException("Docente Materia no encontrado"));
        licencia.setDocenteMateria(docenteMateria);
        Licencias updatedLicencia = licenciasService.save(licencia);
        return ResponseEntity.ok(updatedLicencia);
    }

    @DeleteMapping("/delete-licencia/{id}")
    public ResponseEntity<Void> deleteLicencia(@PathVariable Integer id) {
        licenciasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

