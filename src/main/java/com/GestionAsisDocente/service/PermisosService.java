package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.PermisosRequest;
import com.GestionAsisDocente.entity.Permisos;
import com.GestionAsisDocente.repository.PermisosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisosService {

    @Autowired
    private PermisosRepository permisosRepository;

    public List<Permisos> getAllPermisos() {
        return permisosRepository.findAll();
    }

    public Permisos createPermiso(PermisosRequest permisoRequest) {
        Permisos permiso = new Permisos();
        permiso.setNombre(permisoRequest.getNombre());
        return permisosRepository.save(permiso);
    }

    public Permisos updatePermiso(Integer id, PermisosRequest permisoRequest) {
        Permisos permiso = permisosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permiso not found with id " + id));
        permiso.setNombre(permisoRequest.getNombre());
        return permisosRepository.save(permiso);
    }

    public void deletePermiso(Integer id) {
        Permisos permiso = permisosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permiso not found with id " + id));
        permisosRepository.delete(permiso);
    }

    public Permisos getPermisoById(Integer id) {
        return permisosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permiso not found with id " + id));
    }
}
