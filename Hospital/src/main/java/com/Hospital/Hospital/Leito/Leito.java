package com.Hospital.Hospital.Leito;

import com.Hospital.Hospital.GerarID.EntityId;
import com.Hospital.Hospital.LogInternacoes.LogInternacoes;
import com.Hospital.Hospital.Paciente.Paciente;
import com.Hospital.Hospital.Situacao.SituacaoLeito;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "leito")
public class Leito extends EntityId {

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "status")
    private SituacaoLeito status;

    @Column(name = "paciente_id")
    private Integer pacienteId;

    @OneToMany(mappedBy = "leito", cascade = CascadeType.ALL)
    private List<LogInternacoes> logInternacoesList;

    public void setPaciente(Paciente paciente) {
        paciente = paciente;
    }
    public void setDataInternamento(LocalDateTime dataInternamento) {
        dataInternamento = dataInternamento;
    }

    public void setDataAlta(LocalDateTime dataAlta) {
        dataAlta = dataAlta;
    }
}
