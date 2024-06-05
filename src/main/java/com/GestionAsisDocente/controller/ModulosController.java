package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.ModuloRequest;
import com.GestionAsisDocente.entity.Facultades;
import com.GestionAsisDocente.entity.Modulos;
import com.GestionAsisDocente.service.ModulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ModulosController {

    @Autowired
    private ModulosService modulosService;

    @GetMapping("/get-all-modulos")
    public ResponseEntity<List<Modulos>> getAllModulos() {
        List<Modulos> modulos = modulosService.getAllModulos();
        return ResponseEntity.ok(modulos);
    }

    @PostMapping("/create-modulo")
    public ResponseEntity<Modulos> createModulo(@RequestBody ModuloRequest moduloRequest) {
        Modulos createdModulo = modulosService.createModulo(moduloRequest);
        return ResponseEntity.ok(createdModulo);
    }

    @PutMapping("/update-modulo/{id}")
    public ResponseEntity<Modulos> updateModulo(@PathVariable Integer id, @RequestBody ModuloRequest moduloRequest) {
        Modulos updatedModulo = modulosService.updateModulo(id, moduloRequest);
        return ResponseEntity.ok(updatedModulo);
    }

    @DeleteMapping("/delete-modulo/{id}")
    public ResponseEntity<Void> deleteModulo(@PathVariable Integer id) {
        modulosService.deleteModulo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-modulo/{id}")
    public Modulos getModuloById(@PathVariable Integer id) {
        return modulosService.getModuloById(id);
    }
}
