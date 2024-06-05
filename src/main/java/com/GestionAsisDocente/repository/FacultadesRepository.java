package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.entity.Facultades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultadesRepository extends JpaRepository<Facultades, Integer> {
}
