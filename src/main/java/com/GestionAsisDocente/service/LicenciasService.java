package com.GestionAsisDocente.service;

import com.GestionAsisDocente.entity.Licencias;
import com.GestionAsisDocente.repository.LicenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenciasService {

    @Autowired
    private LicenciasRepository licenciasRepository;

    public List<Licencias> findAll() {
        return licenciasRepository.findAll();
    }

    public Optional<Licencias> findById(Integer id) {
        return licenciasRepository.findById(id);
    }

    public Licencias save(Licencias licencia) {
        return licenciasRepository.save(licencia);
    }

    public void deleteById(Integer id) {
        licenciasRepository.deleteById(id);
    }
}
