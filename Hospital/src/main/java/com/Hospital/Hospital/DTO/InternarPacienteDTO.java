package com.Hospital.Hospital.Paciente;

import com.Hospital.Hospital.Ala.Ala;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternarPacienteDTO {
    private Paciente paciente;
    private Ala ala;
}
