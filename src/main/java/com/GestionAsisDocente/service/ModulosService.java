package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.FacultadRequest;
import com.GestionAsisDocente.dto.ModuloRequest;
import com.GestionAsisDocente.entity.Facultades;
import com.GestionAsisDocente.entity.Modulos;
import com.GestionAsisDocente.repository.FacultadesRepository;
import com.GestionAsisDocente.repository.ModulosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulosService {

    @Autowired
    private ModulosRepository modulosRepository;
    @Autowired
    private FacultadesRepository facultadesRepository;

    public List<Modulos> getAllModulos() {
        return modulosRepository.findAll();
    }


    public Modulos createModulo(ModuloRequest moduloRequest) {
        Facultades facultad = facultadesRepository.findById(moduloRequest.getFacultad_id())
                .orElseThrow(() -> new RuntimeException("Facultad not found with id " + moduloRequest.getFacultad_id()));

        Modulos modulo = new Modulos();
        modulo.setNumero(moduloRequest.getNumero());
        modulo.setDescripcion(moduloRequest.getDescripcion());
        modulo.setUbicacion(moduloRequest.getUbicacion());
        modulo.setFacultad(facultad);

        return modulosRepository.save(modulo);
    }



    public Modulos updateModulo(Integer id, ModuloRequest moduloRequest) {
        Modulos modulo = modulosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modulo not found with id " + id));

        Facultades facultad = facultadesRepository.findById(moduloRequest.getFacultad_id())
                .orElseThrow(() -> new RuntimeException("Facultad not found with id " + moduloRequest.getFacultad_id()));

        modulo.setNumero(moduloRequest.getNumero());
        modulo.setDescripcion(moduloRequest.getDescripcion());
        modulo.setUbicacion(moduloRequest.getUbicacion());
        modulo.setFacultad(facultad);

        return modulosRepository.save(modulo);
    }

    public void deleteModulo(Integer id) {
        Modulos modulo = modulosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modulo not found with id " + id));
        modulosRepository.delete(modulo);
    }

    public Modulos getModuloById(Integer id) {
        return modulosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modulo not found with id " + id));
    }
}
