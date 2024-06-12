package com.GestionAsisDocente.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "docenteMaterias")
public class DocenteMaterias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "docente_id", nullable = false)
    private OurUsers docente;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materias materia;

    private String horario_inicio;
    private String horario_fin;
    private String grupo;
    private String dia;

    @ManyToOne
    @JoinColumn(name = "carrera_id", nullable = false)
    private Carreras carrera;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private Aulas aula;

    @ManyToOne
    @JoinColumn(name = "modulo_id", nullable = false)
    private Modulos modulo;

    @ManyToOne
    @JoinColumn(name = "facultad_id", nullable = false)
    private Facultades facultad;

    // getters and setters
}