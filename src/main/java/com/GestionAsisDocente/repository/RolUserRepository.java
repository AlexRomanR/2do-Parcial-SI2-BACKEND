package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.entity.RolUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolUserRepository extends JpaRepository<RolUser, Integer> {
}
