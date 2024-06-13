package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.DocenteMateriasRequest;
import com.GestionAsisDocente.entity.DocenteMaterias;
import com.GestionAsisDocente.service.DocenteMateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminuser")
public class DocenteMateriasController {

    @Autowired
    private DocenteMateriasService docenteMateriasService;

    @GetMapping("/get-all-docenteMaterias")
    public ResponseEntity<List<DocenteMaterias>> getAllDocenteMaterias() {
        List<DocenteMaterias> docenteMateriasList = docenteMateriasService.findAll();
        return ResponseEntity.ok(docenteMateriasList);
    }

    @GetMapping("/get-all-docenteMateriasByUser/{docenteId}")
    public List<DocenteMaterias> getDocenteMateriasByDocenteId(@PathVariable Integer docenteId) {
        return docenteMateriasService.findByDocenteId(docenteId);
    }

    @PostMapping("/create-docenteMateria")
    public ResponseEntity<DocenteMaterias> createDocenteMaterias(@RequestBody DocenteMateriasRequest request) {
        DocenteMaterias docenteMaterias = docenteMateriasService.save(request);
        return ResponseEntity.ok(docenteMaterias);
    }

    @PutMapping("/update-docenteMateria/{id}")
    public ResponseEntity<DocenteMaterias> updateDocenteMaterias(@PathVariable Integer id, @RequestBody DocenteMateriasRequest request) {
        DocenteMaterias updatedDocenteMaterias = docenteMateriasService.update(id, request);
        return ResponseEntity.ok(updatedDocenteMaterias);
    }

    @DeleteMapping("/delete-docenteMateria/{id}")
    public ResponseEntity<Void> deleteDocenteMaterias(@PathVariable Integer id) {
        docenteMateriasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-docenteMateria/{id}")
    public ResponseEntity<DocenteMaterias> getDocenteMateriasById(@PathVariable Integer id) {
        return docenteMateriasService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
