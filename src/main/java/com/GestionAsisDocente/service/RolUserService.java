package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.RolUserRequest;
import com.GestionAsisDocente.entity.OurUsers;
import com.GestionAsisDocente.entity.RolUser;
import com.GestionAsisDocente.entity.Roles;
import com.GestionAsisDocente.repository.OurUserRepo;
import com.GestionAsisDocente.repository.RolUserRepository;
import com.GestionAsisDocente.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolUserService {

    @Autowired
    private RolUserRepository rolUserRepository;

    @Autowired
    private OurUserRepo ourUsersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public List<RolUser> getAllRolUsers() {
        return rolUserRepository.findAll();
    }

    public RolUser createRolUser(RolUserRequest request) {
        OurUsers user = ourUsersRepository.findById(request.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found with id " + request.getUser_id()));
        Roles rol = rolesRepository.findById(request.getRol_id())
                .orElseThrow(() -> new RuntimeException("Role not found with id " + request.getRol_id()));

        RolUser rolUser = new RolUser();
        rolUser.setUser_id(user);
        rolUser.setRol_id(rol);

        return rolUserRepository.save(rolUser);
    }

    public void deleteRolUser(Integer id) {
        RolUser rolUser = rolUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolUser not found with id " + id));
        rolUserRepository.delete(rolUser);
    }

    public RolUser getRolUserById(Integer id) {
        return rolUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolUser not found with id " + id));
    }
}
