package com.GestionAsisDocente.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "materias")
public class Materias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sigla;
    private String nombre;

    @ManyToMany(mappedBy = "materias")
    private Set<Carreras> carreras;



}


