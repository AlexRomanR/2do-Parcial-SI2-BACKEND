package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.LicenciasRequest;
import com.GestionAsisDocente.entity.Licencias;
import com.GestionAsisDocente.entity.DocenteMaterias;
import com.GestionAsisDocente.repository.LicenciasRepository;
import com.GestionAsisDocente.repository.DocenteMateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicenciasService {

    @Autowired
    private LicenciasRepository licenciasRepository;

    @Autowired
    private DocenteMateriasRepository docenteMateriasRepository;

    public List<Licencias> getAllLicencias() {
        return licenciasRepository.findAll();
    }

    public Licencias createLicencia(LicenciasRequest licenciasRequest) {
        Licencias licencia = new Licencias();
        DocenteMaterias docenteMaterias = docenteMateriasRepository.findById(licenciasRequest.getDocente_materia_id())
                .orElseThrow(() -> new RuntimeException("DocenteMateria not found with id " + licenciasRequest.getDocente_materia_id()));

        licencia.setDocenteMaterias(docenteMaterias);
        licencia.setMotivo(licenciasRequest.getMotivo());
        licencia.setEstado(licenciasRequest.getEstado());
        licencia.setFecha(licenciasRequest.getFecha());

        return licenciasRepository.save(licencia);
    }

    public Licencias updateLicencia(Integer id, LicenciasRequest licenciasRequest) {
        Licencias licencia = licenciasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Licencia not found with id " + id));

        DocenteMaterias docenteMaterias = docenteMateriasRepository.findById(licenciasRequest.getDocente_materia_id())
                .orElseThrow(() -> new RuntimeException("DocenteMateria not found with id " + licenciasRequest.getDocente_materia_id()));

        licencia.setDocenteMaterias(docenteMaterias);
        licencia.setMotivo(licenciasRequest.getMotivo());
        licencia.setEstado(licenciasRequest.getEstado());
        licencia.setFecha(licenciasRequest.getFecha());

        return licenciasRepository.save(licencia);
    }

    public void deleteLicencia(Integer id) {
        Licencias licencia = licenciasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Licencia not found with id " + id));
        licenciasRepository.delete(licencia);
    }

    public Licencias getLicenciaById(Integer id) {
        return licenciasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Licencia not found with id " + id));
    }

    public List<Licencias> getLicenciasByDocenteMateriaId(Integer docenteMateriaId) {
        return licenciasRepository.findByDocenteMateriasId(docenteMateriaId);
    }

    public List<Licencias> getLicenciasByDocenteId(Integer docenteId) {
        List<DocenteMaterias> docenteMaterias = docenteMateriasRepository.findByDocenteId(docenteId);
        List<Licencias> licencias = new ArrayList<>();
        for (DocenteMaterias dm : docenteMaterias) {
            licencias.addAll(licenciasRepository.findByDocenteMateriasId(dm.getId()));
        }
        return licencias;
    }
}
