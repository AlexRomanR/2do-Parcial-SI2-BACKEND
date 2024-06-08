package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.MateriasRequest;
import com.GestionAsisDocente.entity.Carreras;
import com.GestionAsisDocente.entity.Materias;
import com.GestionAsisDocente.repository.CarrerasRepository;
import com.GestionAsisDocente.repository.MateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriasService {
    @Autowired
    private MateriasRepository materiaRepository;

    @Autowired
    private CarrerasRepository carreraRepository;

    public List<Materias> getAllMaterias() {
        return materiaRepository.findAll();
    }
    public Materias createMateria(MateriasRequest materiasRequest) {
        Materias materia = new Materias();
        materia.setSigla(materiasRequest.getSigla());
        materia.setNombre(materiasRequest.getNombre());

        // Guardar la nueva materia
        materia = materiaRepository.save(materia);

        // Asignar la carrera a la materia (si existe)
        Integer carreraId = materiasRequest.getCarrera_id();
        if (carreraId != null) {
            Carreras carrera = carreraRepository.findById(carreraId)
                    .orElseThrow(() -> new RuntimeException("Carrera not found with id " + carreraId));
            materia.getCarreras().add(carrera);
        }

        return materia;
    }


    public Materias updateMateria(Integer id, MateriasRequest materiasRequest) {
        Materias materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia not found with id " + id));

        materia.setSigla(materiasRequest.getSigla());
        materia.setNombre(materiasRequest.getNombre());
        // Actualiza cualquier otro atributo de la materia según sea necesario

        return materiaRepository.save(materia);
    }

    public void deleteMateria(Integer id) {
        Materias materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia not found with id " + id));
        materiaRepository.delete(materia);
    }

    public Materias getMateriaById(Integer id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia not found with id " + id));
    }

    public Materias addCarreraToMateria(Integer materiaId, Integer carreraId) {
        Materias materia = materiaRepository.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia not found with id " + materiaId));
        Carreras carrera = carreraRepository.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera not found with id " + carreraId));
        materia.getCarreras().add(carrera);
        return materiaRepository.save(materia);
    }

    public Materias removeCarreraFromMateria(Integer materiaId, Integer carreraId) {
        Materias materia = materiaRepository.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia not found with id " + materiaId));
        Carreras carrera = carreraRepository.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera not found with id " + carreraId));
        materia.getCarreras().remove(carrera);
        return materiaRepository.save(materia);
    }
}
