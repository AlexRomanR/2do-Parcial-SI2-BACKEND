package com.GestionAsisDocente.dto;


import lombok.Data;

@Data
public class AulasRequest{
    private Integer numero;
    private Integer piso;
    private Integer capacidad;
    private String descripcion;
    private Integer modulo_id;

}
