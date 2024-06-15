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

    @Column(name = "motivo", nullable = false)
    private String motivo;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_actual", nullable = false, updatable = false)
    private Date fechaActual;

    @PrePersist
    protected void onCreate() {
        this.fechaActual = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "docente_materia_id", nullable = false)
    private DocenteMaterias docenteMateria;
}
