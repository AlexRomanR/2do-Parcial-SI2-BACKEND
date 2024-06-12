package com.GestionAsisDocente.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "aulas")
public class Aulas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    private Integer piso;
    private Integer capacidad;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "modulo_id", nullable = true)
    @JsonBackReference
    private Modulos modulos;


    // Añadir este método para exponer el facultad_id
    @JsonProperty("modulo_id")
    public Integer getModuloId() {
        return modulos != null ? modulos.getId() : null;
    }



}
