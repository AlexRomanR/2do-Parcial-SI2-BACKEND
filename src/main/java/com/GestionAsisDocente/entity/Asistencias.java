package com.GestionAsisDocente.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "asistencias")
public class Asistencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "docenteMateria_id", nullable = false)
    private DocenteMaterias docenteMaterias;

    private String estado;
    private String horaMarcada;
    private String fecha;

    // Getters and Setters
}
