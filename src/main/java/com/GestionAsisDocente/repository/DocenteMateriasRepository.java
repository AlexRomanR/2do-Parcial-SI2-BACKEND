package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.entity.DocenteMaterias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DocenteMateriasRepository extends JpaRepository<DocenteMaterias, Integer> {
    List<DocenteMaterias> findByDocenteId(Integer docente_id);
}
