package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.AulasRequest;
import com.GestionAsisDocente.entity.Aulas;
import com.GestionAsisDocente.entity.Facultades;
import com.GestionAsisDocente.service.AulasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AulasController {

    @Autowired
    private AulasService aulasService;

    @GetMapping("/get-all-aulas")
    public ResponseEntity<List<Aulas>> getAllAulas() {
        List<Aulas> aulas = aulasService.getAllAulas();
        return ResponseEntity.ok(aulas);
    }

    @PostMapping("/create-aula")
    public ResponseEntity<Aulas> createAula(@RequestBody AulasRequest aulasRequest) {
        Aulas createdAula = aulasService.createAula(aulasRequest);
        return ResponseEntity.ok(createdAula);
    }

    @PutMapping("/update-aula/{id}")
    public ResponseEntity<Aulas> updateAula(@PathVariable Integer id, @RequestBody AulasRequest aulasRequest) {
        Aulas updatedAula = aulasService.updateAula(id, aulasRequest);
        return ResponseEntity.ok(updatedAula);
    }

    @DeleteMapping("/delete-aula/{id}")
    public ResponseEntity<Void> deleteAula(@PathVariable Integer id) {
        aulasService.deleteAula(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/get-aula/{id}")
    public Aulas getAulaById(@PathVariable Integer id) {
        return aulasService.getAulaById(id);
    }
}
