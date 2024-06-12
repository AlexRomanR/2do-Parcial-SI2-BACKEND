package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.DocenteMateriasRequest;
import com.GestionAsisDocente.entity.DocenteMaterias;
import com.GestionAsisDocente.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteMateriasService {

    @Autowired
    private DocenteMateriasRepository docenteMateriasRepository;

    @Autowired
    private OurUserRepo docenteRepository;

    @Autowired
    private MateriasRepository materiasRepository;

    @Autowired
    private CarrerasRepository carreraRepository;

    @Autowired
    private AulasRepository aulaRepository;

    @Autowired
    private ModulosRepository moduloRepository;

    @Autowired
    private FacultadesRepository facultadRepository;

    public List<DocenteMaterias> findAll() {
        return docenteMateriasRepository.findAll();
    }

    public Optional<DocenteMaterias> findById(Integer id) {
        return docenteMateriasRepository.findById(id);
    }

    public DocenteMaterias save(DocenteMateriasRequest request) {
        DocenteMaterias docenteMaterias = new DocenteMaterias();
        docenteMaterias.setDocente(docenteRepository.findById(request.getDocente_id()).orElseThrow(() -> new RuntimeException("Docente not found")));
        docenteMaterias.setMateria(materiasRepository.findById(request.getMateria_id()).orElseThrow(() -> new RuntimeException("Materia not found")));
        docenteMaterias.setHorario_inicio(request.getHorario_inicio());
        docenteMaterias.setHorario_fin(request.getHorario_fin());
        docenteMaterias.setGrupo(request.getGrupo());
        docenteMaterias.setDia(request.getDia());
        docenteMaterias.setCarrera(carreraRepository.findById(request.getCarrera_id()).orElseThrow(() -> new RuntimeException("Carrera not found")));
        docenteMaterias.setAula(aulaRepository.findById(request.getAula_id()).orElseThrow(() -> new RuntimeException("Aula not found")));
        docenteMaterias.setModulo(moduloRepository.findById(request.getModulo_id()).orElseThrow(() -> new RuntimeException("Modulo not found")));
        docenteMaterias.setFacultad(facultadRepository.findById(request.getFacultad_id()).orElseThrow(() -> new RuntimeException("Facultad not found")));
        return docenteMateriasRepository.save(docenteMaterias);
    }

    public void deleteById(Integer id) {
        docenteMateriasRepository.deleteById(id);
    }

    public DocenteMaterias update(Integer id, DocenteMateriasRequest request) {
        DocenteMaterias docenteMaterias = docenteMateriasRepository.findById(id).orElseThrow(() -> new RuntimeException("DocenteMaterias not found"));
        docenteMaterias.setDocente(docenteRepository.findById(request.getDocente_id()).orElseThrow(() -> new RuntimeException("Docente not found")));
        docenteMaterias.setMateria(materiasRepository.findById(request.getMateria_id()).orElseThrow(() -> new RuntimeException("Materia not found")));
        docenteMaterias.setHorario_inicio(request.getHorario_inicio());
        docenteMaterias.setHorario_fin(request.getHorario_fin());
        docenteMaterias.setGrupo(request.getGrupo());
        docenteMaterias.setDia(request.getDia());
        docenteMaterias.setCarrera(carreraRepository.findById(request.getCarrera_id()).orElseThrow(() -> new RuntimeException("Carrera not found")));
        docenteMaterias.setAula(aulaRepository.findById(request.getAula_id()).orElseThrow(() -> new RuntimeException("Aula not found")));
        docenteMaterias.setModulo(moduloRepository.findById(request.getModulo_id()).orElseThrow(() -> new RuntimeException("Modulo not found")));
        docenteMaterias.setFacultad(facultadRepository.findById(request.getFacultad_id()).orElseThrow(() -> new RuntimeException("Facultad not found")));
        return docenteMateriasRepository.save(docenteMaterias);
    }
}
