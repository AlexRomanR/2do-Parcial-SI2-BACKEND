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

    @ManyToOne
    @JoinColumn(name = "docenteMateria_id", nullable = false)
    private DocenteMaterias docenteMaterias;

    private String motivo;
    private String estado;
    private String fecha;


}
