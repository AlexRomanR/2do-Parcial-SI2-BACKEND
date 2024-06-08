package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.RolUserRequest;
import com.GestionAsisDocente.entity.RolUser;
import com.GestionAsisDocente.service.RolUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class RolUserController {

    @Autowired
    private RolUserService rolUserService;

    @GetMapping("/get-all-rol-users")
    public ResponseEntity<List<RolUser>> getAllRolUsers() {
        List<RolUser> rolUsers = rolUserService.getAllRolUsers();
        return ResponseEntity.ok(rolUsers);
    }

    @PostMapping("/create-rol-user")
    public ResponseEntity<RolUser> createRolUser(@RequestBody RolUserRequest request) {
        RolUser rolUser = rolUserService.createRolUser(request);
        return ResponseEntity.ok(rolUser);
    }

    @DeleteMapping("/delete-rol-user/{id}")
    public ResponseEntity<Void> deleteRolUser(@PathVariable Integer id) {
        rolUserService.deleteRolUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-rol-user/{id}")
    public ResponseEntity<RolUser> getRolUserById(@PathVariable Integer id) {
        RolUser rolUser = rolUserService.getRolUserById(id);
        return ResponseEntity.ok(rolUser);
    }
}
