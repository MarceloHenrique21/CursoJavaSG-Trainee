package com.Hospital.Hospital.Leito;

import com.Hospital.Hospital.GerarID.EntityId;
import com.Hospital.Hospital.Situacao.SituacaoLeito;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "leito")
public class Leito extends EntityId {

    @Column(name = "codigo")
    private int codigo;

    @Column(name = "status")
    private SituacaoLeito status;

    @Column(name = "paciente_id")
    private Integer pacienteId;
}
