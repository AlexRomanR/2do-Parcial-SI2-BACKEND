package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.FacultadRequest;
import com.GestionAsisDocente.dto.ReqRes;
import com.GestionAsisDocente.entity.Facultades;
import com.GestionAsisDocente.entity.OurUsers;
import com.GestionAsisDocente.repository.FacultadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultadesService {

    @Autowired
    private FacultadesRepository facultadesRepository;

    public List<Facultades> getAllFacultades() {
        return facultadesRepository.findAll();
    }

    public Facultades createFacultad(FacultadRequest facultadRequest) {
        Facultades facultad = new Facultades();
        facultad.setNombre(facultadRequest.getNombre());
        facultad.setDescripcion(facultadRequest.getDescripcion());
        return facultadesRepository.save(facultad);
    }

    public Facultades updateFacultad(Integer id, FacultadRequest facultadRequest) {
        Facultades facultad = facultadesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facultad not found with id " + id));
        facultad.setNombre(facultadRequest.getNombre());
        facultad.setDescripcion(facultadRequest.getDescripcion());
        return facultadesRepository.save(facultad);
    }

    public void deleteFacultad(Integer id) {
        Facultades facultad = facultadesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facultad not found with id " + id));
        facultadesRepository.delete(facultad);
    }

    public Facultades getFacultadById(Integer id) {
        return facultadesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facultad not found with id " + id));
    }





}