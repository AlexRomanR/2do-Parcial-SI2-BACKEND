package com.GestionAsisDocente.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "modulos")
public class Modulos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    private String descripcion;
    private String ubicacion;


    @ManyToOne
    @JoinColumn(name = "facultad_id", nullable = true)
    @JsonBackReference
    private Facultades facultad;

    @OneToMany(mappedBy = "modulos", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Aulas> aulas;

    // Añadir este método para exponer el facultad_id
    @JsonProperty("facultad_id")
    public Integer getFacultadId() {
        return facultad != null ? facultad.getId() : null;
    }
}
