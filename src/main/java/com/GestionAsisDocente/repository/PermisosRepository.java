package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.entity.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermisosRepository extends JpaRepository<Permisos, Integer> {

}
