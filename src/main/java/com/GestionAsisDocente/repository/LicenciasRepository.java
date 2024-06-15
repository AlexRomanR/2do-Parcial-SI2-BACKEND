package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.entity.Licencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenciasRepository extends JpaRepository<Licencias, Integer> {
}