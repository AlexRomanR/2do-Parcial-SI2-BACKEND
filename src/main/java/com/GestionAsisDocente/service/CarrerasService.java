package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.CarrerasRequest;
import com.GestionAsisDocente.entity.Carreras;
import com.GestionAsisDocente.entity.Materias;
import com.GestionAsisDocente.repository.CarrerasRepository;
import com.GestionAsisDocente.repository.MateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CarrerasService {
    @Autowired
    private CarrerasRepository carreraRepository;

    @Autowired
    private MateriasRepository materiaRepository;

    public List<Carreras> getAllCarreras() {
        return carreraRepository.findAll();
    }

    public Carreras createCarrera(CarrerasRequest carrerasRequest) {
        Carreras carrera = new Carreras();
        carrera.setCodigo(carrerasRequest.getCodigo());
        carrera.setNombre(carrerasRequest.getNombre());

        // Guardar la nueva carrera
        carrera = carreraRepository.save(carrera);
        Integer materiaId = carrerasRequest.getMateria_id();
        if (materiaId != null) {
            Materias materia = materiaRepository.findById(materiaId)
                    .orElseThrow(() -> new RuntimeException("Materia not found with id " + materiaId));
            materia.getCarreras().add(carrera);
            carrera.getMaterias().add(materia);
        }
        return carrera;
    }


    public Carreras updateCarrera(Integer id, CarrerasRequest carrerasRequest) {
        Carreras carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera not found with id " + id));

        carrera.setCodigo(carrerasRequest.getCodigo());
        carrera.setNombre(carrerasRequest.getNombre());

        return carreraRepository.save(carrera);
    }

    public void deleteCarrera(Integer id) {
        Carreras carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera not found with id " + id));
        carreraRepository.delete(carrera);
    }

    public Carreras getCarreraById(Integer id) {
        return carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera not found with id " + id));
    }
}
