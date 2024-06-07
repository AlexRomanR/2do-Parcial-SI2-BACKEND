package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.CarrerasRequest;
import com.GestionAsisDocente.entity.Carreras;
import com.GestionAsisDocente.service.CarrerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class CarrerasController {

    @Autowired
    private CarrerasService carrerasService;

    @GetMapping("/get-all-carreras")
    public ResponseEntity<List<Carreras>> getAllCarreras() {
        List<Carreras> carreras = carrerasService.getAllCarreras();
        return ResponseEntity.ok(carreras);
    }

    @PostMapping("/create-carrera")
    public ResponseEntity<Carreras> createCarrera(@RequestBody CarrerasRequest carrerasRequest) {
        Carreras createdCarrera = carrerasService.createCarrera(carrerasRequest);
        return ResponseEntity.ok(createdCarrera);
    }

    @PutMapping("/update-carrera/{id}")
    public ResponseEntity<Carreras> updateCarrera(@PathVariable Integer id, @RequestBody CarrerasRequest carrerasRequest) {
        Carreras updatedCarrera = carrerasService.updateCarrera(id, carrerasRequest);
        return ResponseEntity.ok(updatedCarrera);
    }

    @DeleteMapping("/delete-carrera/{id}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable Integer id) {
        carrerasService.deleteCarrera(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-carrera/{id}")
    public Carreras getCarreraById(@PathVariable Integer id) {
        return carrerasService.getCarreraById(id);
    }
}
