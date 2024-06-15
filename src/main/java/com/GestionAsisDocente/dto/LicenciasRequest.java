package com.GestionAsisDocente.dto;

import lombok.Data;
import java.util.Date;

@Data
public class LicenciasRequest {
    private String motivo;
    private Integer docenteMateriaId;
}