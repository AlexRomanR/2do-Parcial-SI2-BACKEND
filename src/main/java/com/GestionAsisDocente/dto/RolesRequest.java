package com.GestionAsisDocente.dto;

import lombok.Data;

import java.util.List;


@Data
public class RolesRequest {
    private String nombre;
    private List<Integer> permissions;



}
