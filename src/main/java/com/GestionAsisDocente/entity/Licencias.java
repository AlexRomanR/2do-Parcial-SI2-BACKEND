package com.GestionAsisDocente.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.Name;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "licencias")
public class Licencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "motivo")
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "docente_materia_id")
    private DocenteMaterias docenteMateria;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "fecha_actual")
    private Date fechaActual;

}
