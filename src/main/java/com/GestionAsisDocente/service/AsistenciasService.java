package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.AsistenciasRequest;
import com.GestionAsisDocente.entity.Asistencias;
import com.GestionAsisDocente.entity.DocenteMaterias;
import com.GestionAsisDocente.repository.AsistenciasRepository;
import com.GestionAsisDocente.repository.DocenteMateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsistenciasService {

    @Autowired
    private AsistenciasRepository asistenciaRepository;

    @Autowired
    private DocenteMateriasRepository docenteMateriasRepository;

    public List<Asistencias> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    public Asistencias createAsistencia(AsistenciasRequest asistenciaRequest) {
        Asistencias asistencia = new Asistencias();
        DocenteMaterias docenteMaterias = docenteMateriasRepository.findById(asistenciaRequest.getDocente_materia_id())
                .orElseThrow(() -> new RuntimeException("DocenteMateria not found with id " + asistenciaRequest.getDocente_materia_id()));

        asistencia.setDocenteMaterias(docenteMaterias);
        asistencia.setEstado(asistenciaRequest.getEstado());
        asistencia.setHoraMarcada(asistenciaRequest.getHora_marcada());
        asistencia.setFecha(asistenciaRequest.getFecha());

        return asistenciaRepository.save(asistencia);
    }

    public Asistencias updateAsistencia(Integer id, AsistenciasRequest asistenciaRequest) {
        Asistencias asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistencia not found with id " + id));

        DocenteMaterias docenteMaterias = docenteMateriasRepository.findById(asistenciaRequest.getDocente_materia_id())
                .orElseThrow(() -> new RuntimeException("DocenteMateria not found with id " + asistenciaRequest.getDocente_materia_id()));

        asistencia.setDocenteMaterias(docenteMaterias);
        asistencia.setEstado(asistenciaRequest.getEstado());
        asistencia.setHoraMarcada(asistenciaRequest.getHora_marcada());
        asistencia.setFecha(asistenciaRequest.getFecha());

        return asistenciaRepository.save(asistencia);
    }

    public void deleteAsistencia(Integer id) {
        Asistencias asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistencia not found with id " + id));
        asistenciaRepository.delete(asistencia);
    }

    public Asistencias getAsistenciaById(Integer id) {
        return asistenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistencia not found with id " + id));
    }

    public List<Asistencias> getAsistenciasByDocenteMateriaId(Integer docenteMateriaId) {
        return asistenciaRepository.findByDocenteMateriasId(docenteMateriaId);
    }

    public List<Asistencias> getAsistenciasByDocenteId(Integer docenteId) {
        List<DocenteMaterias> docenteMaterias = docenteMateriasRepository.findByDocenteId(docenteId);
        List<Asistencias> asistencias = new ArrayList<>();
        for (DocenteMaterias dm : docenteMaterias) {
            asistencias.addAll(asistenciaRepository.findByDocenteMateriasId(dm.getId()));
        }
        return asistencias;
    }
}
