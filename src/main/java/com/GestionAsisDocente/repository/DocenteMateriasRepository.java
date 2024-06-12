package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.entity.DocenteMaterias;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocenteMateriasRepository extends JpaRepository<DocenteMaterias, Integer> {
}
