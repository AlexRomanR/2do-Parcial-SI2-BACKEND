package com.GestionAsisDocente.repository;
import com.GestionAsisDocente.entity.Asistencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AsistenciasRepository extends JpaRepository<Asistencias, Integer> {
    List<Asistencias> findByDocenteMateriasId(Integer docenteMateria_id);
}