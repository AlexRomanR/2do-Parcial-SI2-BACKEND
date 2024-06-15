package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.LicenciasRequest;
import com.GestionAsisDocente.entity.DocenteMaterias;
import com.GestionAsisDocente.entity.Licencias;
import com.GestionAsisDocente.service.DocenteMateriasService;
import com.GestionAsisDocente.service.LicenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class LicenciasController {

    @Autowired
    private LicenciasService licenciasService;

    @Autowired
    private DocenteMateriasService docenteMateriasService;

    @GetMapping("/get-all-licencias")
    public ResponseEntity<List<LicenciasRequest>> getAllLicencias() {
        List<LicenciasRequest> licenciasRequests = licenciasService.findAll().stream()
                .map(this::convertToDTO)
                .toList();
        return ResponseEntity.ok(licenciasRequests);
    }

    @GetMapping("/get-licencia/{id}")
    public ResponseEntity<LicenciasRequest> getLicenciaById(@PathVariable Integer id) {
        return licenciasService.findById(id)
                .map(licencia -> ResponseEntity.ok(convertToDTO(licencia)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create-licencia")
    public ResponseEntity<LicenciasRequest> createLicencia(@RequestBody LicenciasRequest licenciasRequest) {
        Licencias licencia = convertToEntity(licenciasRequest);
        licencia.setEstado(false); // Default to false
        licencia.setFechaActual(new Date()); // Set current date
        Licencias savedLicencia = licenciasService.save(licencia);
        return ResponseEntity.ok(convertToDTO(savedLicencia));
    }

    @PutMapping("/update-licencia/{id}")
    public ResponseEntity<LicenciasRequest> updateLicencia(@PathVariable Integer id, @RequestBody LicenciasRequest licenciasRequest) {
        Licencias licencia = convertToEntity(licenciasRequest);
        licencia.setId(id);
        Licencias updatedLicencia = licenciasService.save(licencia);
        return ResponseEntity.ok(convertToDTO(updatedLicencia));
    }

    @DeleteMapping("/delete-licencia/{id}")
    public ResponseEntity<Void> deleteLicencia(@PathVariable Integer id) {
        licenciasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private LicenciasRequest convertToDTO(Licencias licencia) {
        LicenciasRequest licenciasRequest = new LicenciasRequest();
        licenciasRequest.setMotivo(licencia.getMotivo());
        licenciasRequest.setDocenteMateriaId(licencia.getDocenteMateria().getId());
        return licenciasRequest;
    }

    private Licencias convertToEntity(LicenciasRequest licenciasRequest) {
        Licencias licencia = new Licencias();
        licencia.setMotivo(licenciasRequest.getMotivo());
        Optional<DocenteMaterias> docenteMateria = docenteMateriasService.findById(licenciasRequest.getDocenteMateriaId());
        docenteMateria.ifPresent(licencia::setDocenteMateria);
        return licencia;
    }
}
