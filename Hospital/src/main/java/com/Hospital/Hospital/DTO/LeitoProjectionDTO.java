package com.Hospital.Hospital.DTO;

import com.Hospital.Hospital.Leito.LeitoProjection;

public class LeitoProjectionDTO {
    private Integer id;
    private String codigo;

    public LeitoProjectionDTO(LeitoProjection leitoProjection) {
        this.id = leitoProjection.getId();
        this.codigo = leitoProjection.getCodigoLeito();
    }
}