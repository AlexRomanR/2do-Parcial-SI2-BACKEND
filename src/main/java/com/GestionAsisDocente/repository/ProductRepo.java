package com.GestionAsisDocente.repository;

import com.GestionAsisDocente.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}