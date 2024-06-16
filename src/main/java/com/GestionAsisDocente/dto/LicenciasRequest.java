package com.GestionAsisDocente.dto;

import lombok.Data;
import java.util.Date;

@Data
public class LicenciasRequest {
    private Integer id;
    private Integer docente_materia_id;
    private String motivo;
    private String estado;
    private String fecha;

}