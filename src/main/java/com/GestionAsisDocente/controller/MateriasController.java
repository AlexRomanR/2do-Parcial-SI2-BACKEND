package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.FacultadRequest;
import com.GestionAsisDocente.dto.MateriasRequest;
import com.GestionAsisDocente.entity.Facultades;
import com.GestionAsisDocente.entity.Materias;
import com.GestionAsisDocente.service.FacultadesService;
import com.GestionAsisDocente.service.MateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MateriasController {

    @Autowired
    private MateriasService materiasService;

    @GetMapping("/get-all-materias")
    public ResponseEntity<List<Materias>> getAllMaterias() {
        List<Materias> materias = materiasService.getAllMaterias();
        return ResponseEntity.ok(materias);
    }


    @PostMapping("/create-materia")
    public ResponseEntity<Materias> createMateria(@RequestBody MateriasRequest materiasRequest) {
        Materias materia = materiasService.createMateria(materiasRequest);
        return ResponseEntity.ok(materia);
    }

    @PutMapping("/update-materia/{id}")
    public ResponseEntity<Materias> updateMateria(@PathVariable Integer id, @RequestBody MateriasRequest materiasRequest) {
        Materias updatedMateria = materiasService.updateMateria(id, materiasRequest);
        return ResponseEntity.ok(updatedMateria);
    }

    @DeleteMapping("/delete-materia/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable Integer id) {
        materiasService.deleteMateria(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/get-materia/{id}")
    public Materias getMateriaById(@PathVariable Integer id) {
        return materiasService.getMateriaById(id);
    }


}
