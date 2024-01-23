package com.Hospital.Hospital.Leito;

import com.Hospital.Hospital.GerarID.EntityId;
import com.Hospital.Hospital.Paciente.Paciente;
import com.Hospital.Hospital.Quarto.Quarto;
import com.Hospital.Hospital.Situacao.SituacaoLeito;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "leito")
public class Leito extends EntityId {

    @Column(name = "codigo")
    private int codigo;

    @Column(name = "status")
    private SituacaoLeito status;

    @JoinColumn(name = "quarto_id")
    List<Quarto> QuartoList;

    @JoinColumn(name = "paciente_id")
    List<Paciente> PacienteList;
}
