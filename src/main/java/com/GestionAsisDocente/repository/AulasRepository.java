package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.entity.Aulas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulasRepository extends JpaRepository<Aulas, Integer> {
}
