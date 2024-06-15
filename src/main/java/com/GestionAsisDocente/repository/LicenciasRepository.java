package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.entity.Licencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenciasRepository extends JpaRepository<Licencias, Integer> {
    List<Licencias> findByDocenteMateriaId(Integer docenteMateriaId);
}
